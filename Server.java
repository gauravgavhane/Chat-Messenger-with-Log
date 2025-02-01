import java.net.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Server class for the Chat Messenger application.
 * Listens for client connections and enables peer-to-peer communication.
 * Maintains a log of the chat session with a timestamped filename.
 */
class Server {
    public static void main(String[] args) {
        try {
            System.out.println("Server application is running...");
            System.out.println("--------------------------------");

            // Create server socket on port 2100
            ServerSocket ssobj = new ServerSocket(2100);
            System.out.println("Waiting for client at port number 2100...");

            // Accept incoming client connection
            Socket sobj = ssobj.accept();
            System.out.println("Connection established with the client..");

            // Set up input/output streams for communication
            PrintStream ps = new PrintStream(sobj.getOutputStream());
            BufferedReader br1 = new BufferedReader(new InputStreamReader(sobj.getInputStream()));
            BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));

            // Generate a timestamped log file
            String timestamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
            FileWriter logWriter = new FileWriter("server_chat_log_" + timestamp + ".txt");
            BufferedWriter logBuffer = new BufferedWriter(logWriter);

            String str1, str2;

            System.out.println("=====================================");
            System.out.println("Chat Messenger application started...");
            System.out.println("=====================================");

            // Chat loop: read client message, respond, and log conversation
            while ((str1 = br1.readLine()) != null) {
                System.out.println("Client: " + str1);

                // Log client's message
                logBuffer.write("Client: " + str1);
                logBuffer.newLine();

                System.out.print("SERVER: ");
                str2 = br2.readLine();

                // Log server's response
                logBuffer.write("Server: " + str2);
                logBuffer.newLine();
                logBuffer.flush(); // Ensure data is written immediately

                ps.println(str2); // Send response to client
            }

            System.out.println("Thank you for using the Chat Application..");

            // Close all resources
            logBuffer.close();
            logWriter.close();
            br1.close();
            br2.close();
            ps.close();
            sobj.close();
            ssobj.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
