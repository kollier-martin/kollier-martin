package UDP;

import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Objects;
import java.util.logging.Logger;

import static UDP.constants.UDPVariables.AVERAGE_TIME_TAKEN;
import static UDP.constants.UDPVariables.CLIENT_DONE;
import static UDP.constants.UDPVariables.CLIENT_READY;
import static UDP.constants.UDPVariables.END_RECEIVING;
import static UDP.constants.UDPVariables.FILE_NAME;
import static UDP.constants.UDPVariables.PORT;
import static UDP.constants.UDPVariables.READY_TO_RECEIVE_FILE;
import static UDP.constants.UDPVariables.SERVER_CREATED_TEXT_PATH;
import static UDP.constants.UDPVariables.TIME_TAKEN;
import static java.nio.charset.StandardCharsets.UTF_8;
import static java.nio.file.StandardOpenOption.APPEND;
import static java.nio.file.StandardOpenOption.CREATE;
import static java.nio.file.StandardOpenOption.WRITE;
import static java.util.logging.Level.INFO;
import static java.util.logging.Level.SEVERE;
import static java.util.logging.Level.WARNING;

public class UDPServer {
    private static final Logger SERVER_LOGGER;

    // Stores the original file in the server
    private static final String CURRENT_PATH;
    private static final String ORIGINAL_FILE;

    // Path for the files that the server creates
    private static final String NEW_FILE;

    // Creates a Path variable of the original file
    private static final Path ORIGINAL_PATH;
    // Places strings that specify when an error or success happened
    private static final ArrayList<String> errorCatcher;
    private static final ArrayList<String> successCatcher;
    // Array of all the times of file retrieval
    private static final long[] receiveTimes;
    private static final Path RECEIVED_FILES_DIR;
    private static final Path LOGS_DIR;
    // Will be used to write to server file
    private static Writer fileWriter;
    // Variables for counting the times the data is received from the Client, and if it is successful or not
    private static int receivedCounter = 0;
    private static int errorCounter = 1;

    static {
        SERVER_LOGGER = Logger.getLogger(UDPServer.class.getName());

        errorCatcher = new ArrayList<>();
        successCatcher = new ArrayList<>();
        receiveTimes = new long[100];

        CURRENT_PATH = System.getProperty("user.dir");
        ORIGINAL_FILE = CURRENT_PATH + FILE_NAME;
        ORIGINAL_PATH = Paths.get(ORIGINAL_FILE);
        NEW_FILE = CURRENT_PATH + SERVER_CREATED_TEXT_PATH;

        RECEIVED_FILES_DIR = Paths.get(CURRENT_PATH + "\\src\\UDP\\ReceivedFiles");
        LOGS_DIR = Paths.get(CURRENT_PATH + "\\src\\UDP\\logs");

        try {
            if (!Files.exists(LOGS_DIR)) {
                Files.createDirectory(LOGS_DIR);
            }

            if (!Files.exists(RECEIVED_FILES_DIR)) {
                Files.createDirectory(RECEIVED_FILES_DIR);
            }
        } catch (IOException exception) {
            logSevere("Can not create necessary directories. Please, try again.");
            System.exit(0);
        }
    }

    private UDPServer() {
    }

    public static void main(String[] args) throws Exception {
        InetAddress homeIP = InetAddress.getLocalHost();
        createAndListen(homeIP, PORT);
    }

    public static void createAndListen(InetAddress host, int port) {
        // String to hold converted data from the file
        String inFromClient;

        File file;

        // The storage place of the received data
        byte[] receivedData = new byte[1024];

        // Creates a socket to listen at the specified port of the specified host
        try (DatagramSocket srvSocket = new DatagramSocket(port, host)) {
            // As the server waits for the client side to send data, it will wait here
            logInfo(CLIENT_READY);

            while (true) {
                receivedCounter++;

                // Creates Writer object to out to a file in UTF8 encoding
                file = new File(NEW_FILE + receivedCounter + ".txt");

                if (file.createNewFile()) {
                    fileWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, true), UTF_8));
                } else {
                    retry(host, port);
                }

                // The packet that receives the data from the specific IP on a specific port (Incoming Packet)
                DatagramPacket incomingPacket = new DatagramPacket(receivedData, receivedData.length, host, port);
                srvSocket.receive(incomingPacket);

                // Current time at the beginning of receiving
                long t1 = System.currentTimeMillis();

                // The DatagramSocket receives the incoming data packet from the Client (The data arrives in a byte buffer)
                logInfo(READY_TO_RECEIVE_FILE, String.valueOf(receivedCounter));

                // Compares byte data
                errorChecker(receivedData, incomingPacket);

                // Time at the end of file receiving
                long t2 = System.currentTimeMillis();

                // Stores times for average calculation
                for (int i = 0; i < 100; i++) {
                    receiveTimes[i] = t2 - t1;
                }

                // Extracts the data from the incoming packet and casts it as a string
                inFromClient = new String(incomingPacket.getData());

                // Places client data into a new file
                appendFile(inFromClient);

                // Receiving complete
                logInfo(END_RECEIVING, ORIGINAL_FILE.substring(50), String.valueOf(receivedCounter));

                // Time to receive
                logInfo(TIME_TAKEN, String.valueOf(receivedCounter), String.valueOf((t2 - t1)));

                fileWriter.close();

                // Relays average packet receive time
                if (receivedCounter == 100) {
                    logInfo(AVERAGE_TIME_TAKEN, ORIGINAL_FILE.substring(50), String.valueOf(average(receiveTimes)));
                    logInfo("Total Errors: " + errorCatcher.size() + " , Total Success: " + successCatcher.size() + System.lineSeparator());

                    // Creates Writer object to out to a file in UTF8 encoding
                    Path errorFile = new File(CURRENT_PATH + "\\src\\UDP\\logs\\" + Calendar.getInstance().getTimeInMillis() + "-ErrorLog.txt").toPath();

                    for (String error : errorCatcher) {
                        Files.write(errorFile, (error + System.lineSeparator()).getBytes(), CREATE, WRITE, APPEND);
                    }

                    logInfo("Errors logged to file " + errorFile.getFileName() + System.lineSeparator());
                    logInfo(CLIENT_DONE);

                    System.exit(0);
                }
            }
        } catch (Exception e) {
            logSevere("Error occurred - " + e);
            System.exit(0);
        }
    }

    private static void retry(InetAddress host, int port) {
        File f = new File(CURRENT_PATH + "\\src\\UDP\\ReceivedFiles\\");

        try {
            for (File fileToDelete : Objects.requireNonNull(f.listFiles())) {
                if (!fileToDelete.isDirectory()) {
                    Files.delete(fileToDelete.toPath());
                }
            }
        } catch (NullPointerException | IOException ex) {
            logSevere("Path that is supposed to contain the received files does not exist.");
        }

        createAndListen(host, port);
    }

    @SuppressWarnings("SameParameterValue")
    // Calculate the average of a given long array
    private static long average(long[] longArray) {
        int sum = 0;
        int n = longArray.length;

        for (long l : longArray) {
            sum += l;
        }

        return sum / n;
    }

    private static void errorChecker(byte[] receivedData, DatagramPacket incomingPacket) {
        // String to used for checking the data from the file
        String inFromClientChecker;

        // Integer to contain the byte value when reading
        int b;

        // Reads incoming data, Creates local file and Check integrity of file contents
        // ByteArrayInputStream is used for reading bytes
        ByteArrayInputStream bais = new ByteArrayInputStream(receivedData);
        int n = bais.available();
        while ((b = bais.read(incomingPacket.getData(), 0, n)) != -1) {
            logDebug("Byte " + b + " read successfully.");
        }

        inFromClientChecker = bais.toString();
        bais.reset();

        byte[] holderData = new byte[1024];

        try {
            holderData = Files.readAllBytes(ORIGINAL_PATH);
        } catch (IOException e) {
            logSevere("Error occurred - " + e);
        }

        bais = new ByteArrayInputStream(holderData);
        n = bais.available();
        while ((b = bais.read(holderData, 0, n)) != -1) {
            logDebug("Byte " + b + " read successfully.");
        }

        String inFromServerChecker = bais.toString();
        bais.reset();

        if (inFromClientChecker.compareTo(inFromServerChecker) == 0) {
            successCatcher.add("Successful transfer on transaction " + receivedCounter);
        } else {
            errorCatcher.add("Byte mismatch on transfer #" + errorCounter);
            errorCounter++;
        }
    }

    public static void appendFile(String string) throws Exception {
        fileWriter.append(string).append(System.lineSeparator());
    }

    private static void logInfo(final String message) {
        SERVER_LOGGER.log(INFO, message);
    }

    private static void logDebug(final String message) {
        SERVER_LOGGER.log(WARNING, message);
    }

    @SuppressWarnings("SameParameterValue")
    private static void logInfo(final String format, final String... message) {
        SERVER_LOGGER.log(INFO, format, message);
    }

    private static void logSevere(final String message) {
        SERVER_LOGGER.log(SEVERE, message);
    }
}