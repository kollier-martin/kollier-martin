package UDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Logger;

import static UDP.constants.UDPVariables.AM_DONE;
import static UDP.constants.UDPVariables.AVERAGE_RECEIVE_TIME;
import static UDP.constants.UDPVariables.IS_SENDING;
import static UDP.constants.UDPVariables.SEND_END;
import static UDP.constants.UDPVariables.SEND_START;
import static UDP.constants.UDPVariables.TIME_OF_CURRENT;
import static java.util.logging.Level.INFO;
import static java.util.logging.Level.SEVERE;

public class UDPClient {
    private static final Logger SERVER_LOGGER;
    private static final String CURRENT_PATH;
    private static final String FILE_NAME;
    private static int sentCounter;

    static {
        SERVER_LOGGER = Logger.getLogger(UDPClient.class.getName());
        CURRENT_PATH = System.getProperty("user.dir");
        FILE_NAME = CURRENT_PATH + "\\src\\UDP\\FilesToSend\\fileToSend.txt";
        sentCounter = 1;
    }

    private UDPClient() {
    }

    public static void main(String[] args) {
        sendAndListen();
    }

    public static void sendAndListen() {
        byte[] sendData;

        try (DatagramSocket clientSocket = new DatagramSocket(9875, InetAddress.getLocalHost())) {
            // Try with resources creates a socket to send the file to the specified port of the specified host

            // Fetches IP to send over
            InetAddress homeIP = InetAddress.getLocalHost();

            // Fetches file to send
            Path fileOut = Paths.get(FILE_NAME);

            // Reads the specific data path, in this case, the specific file. Then converts it to bytes and adds it to the array
            sendData = Files.readAllBytes(fileOut);
            DatagramPacket sndPacket = new DatagramPacket(sendData, sendData.length, homeIP, 6789);

            for (int i = 0; i < 101; i++) {
                // Begins sending files
                logInfo(SEND_START);
                logInfo(IS_SENDING, FILE_NAME.substring(50), sentCounter);

                // Current time at the beginning of sending current file
                long t1 = System.currentTimeMillis();

                // The DatagramSocket sends the data packet to the Server
                clientSocket.send(sndPacket);

                // Current time at the end of sending current file
                long t2 = System.currentTimeMillis();

                // Finishes sending file
                logInfo(SEND_END, FILE_NAME.substring(50), sentCounter);

                // Time to send
                logInfo(TIME_OF_CURRENT, FILE_NAME.substring(50), sentCounter, t2 - t1);

                sentCounter++;

                // Stores the sending times
                long[] sendTimes = new long[100];
                for (int t = 0; t < 100; t++) {
                    sendTimes[t] = t2 - t1;
                }

                // Relays average packet receive time
                if (sentCounter == 101) {
                    logInfo(AVERAGE_RECEIVE_TIME, FILE_NAME.substring(50), average(sendTimes));
                    logInfo(AM_DONE);
                    System.exit(0);
                }
            }
        } catch (Exception e) {
            logSevere("ERROR - " + e);
        }
    }

    // Calculate the average of a given long array
    private static long average(long[] longArray) {
        int sum = 0;
        int n = longArray.length;

        for (long l : longArray) {
            sum += l;
        }

        return sum / n;
    }

    private static void logInfo(final String message) {
        SERVER_LOGGER.log(INFO, message);
    }

    @SuppressWarnings("SameParameterValue")
    private static void logInfo(final String format, final Object... message) {
        SERVER_LOGGER.log(INFO, format, message);
    }

    private static void logSevere(final String message) {
        SERVER_LOGGER.log(SEVERE, message);
    }
}
