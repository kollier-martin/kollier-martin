package UDP.constants;

public class UDPVariables {
    // Port to Listen at when not specified
    public static final int PORT = 6789;
    // Stores statements that represent the current state of the server
    public static final String SERVER_CREATED_TEXT_PATH = "\\src\\UDP\\ReceivedFiles\\serverCreatedText";
    public static final String FILE_NAME = "\\src\\UDP\\FilesToSend\\fileToSend.txt";
    public static final String CLIENT_READY = "Ready for any client side request.\n";
    public static final String READY_TO_RECEIVE_FILE = "Receiving file #{0}.";
    public static final String END_RECEIVING = "Finished receiving file, \"{0}\", for the {1}th time.";
    public static final String TIME_TAKEN = "Received file number {0} in {1}ms.\n";
    public static final String AVERAGE_TIME_TAKEN = "The average time to receive the file \"{0}\" is {1}ms\n";
    public static final String CLIENT_DONE = "Client file retrieval complete. Thank you.";
    // Client Variables
    public static final String SEND_START = "I am sending the designated file to the server.";
    public static final String IS_SENDING = "I am sending the file \"{0}\" for the {1}" + "th time.";
    public static final String SEND_END = "I have finished sending the file \"{0}\" for the {1}" + "th time.";
    public static final String TIME_OF_CURRENT = "\"{0}\" has been sent for the {1}th in {2}ms.\n";
    public static final String AVERAGE_RECEIVE_TIME = "The average time to send the file \"{0}\" is {1}ms\n";
    public static final String AM_DONE = "I am done.";
    private UDPVariables() {
    }
}
