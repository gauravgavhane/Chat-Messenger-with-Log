import java.net.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Client class for the Chat Messenger application.
 * Connects to the server and enables peer-to-peer chat.
 * Maintains a log of the chat session with a timestamped filename.
 */
class Client {
    public static void main(String[] args) {
        try {
            System.out.println("Client application is running...");
            System.out.println("--------------------------------");

            // Connect to the server running on localhost at port 2100
            System.out.println("Connecting to server...");
            Socket sobj = new Socket("localhost", 2100);
            System.out.println("Connection established with the server..");

            // Set up input/output streams for communication
            PrintStream ps = new PrintStream(sobj.getOutputStream());
            BufferedReader br1 = new BufferedReader(new InputStreamReader(sobj.getInputStream()));
            BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));

            // Generate a timestamped log file
            String timestamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
            FileWriter logWriter = new FileWriter("client_chat_log_" + timestamp + ".txt");
            BufferedWriter logBuffer = new BufferedWriter(logWriter);

            String str1, str2;

            System.out.println("=====================================");
            System.out.println("Chat Messenger application started...");
            System.out.println("=====================================");

            // Chat loop: send message, receive response, and log conversation
            while (!(str1 = br2.readLine()).equals("end")) {
                ps.println(str1);

                // Log client's message
                logBuffer.write("Client: " + str1);
                logBuffer.newLine();

                str2 = br1.readLine();
                System.out.println("Server: " + str2);

                // Log server's response
                logBuffer.write("Server: " + str2);
                logBuffer.newLine();
                logBuffer.flush(); // Ensure data is written immediately

                System.out.println("-------------------------------------");
                System.out.print("CLIENT: ");
            }

            System.out.println("Thank you for using the Chat Application..");

            // Close all resources
            logBuffer.close();
            logWriter.close();
            br1.close();
            br2.close();
            ps.close();
            sobj.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
