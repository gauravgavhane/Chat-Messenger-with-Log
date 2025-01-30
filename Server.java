import java.net.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

class Server {
    public static void main(String[] args) {
        try {
            System.out.println("Server application is running...");
            System.out.println("--------------------------------");

            ServerSocket ssobj = new ServerSocket(2100);
            System.out.println("Waiting for client at port number 2100...");

            Socket sobj = ssobj.accept(); // Accept client request
            System.out.println("Connection established with the client..");

            PrintStream ps = new PrintStream(sobj.getOutputStream());
            BufferedReader br1 = new BufferedReader(new InputStreamReader(sobj.getInputStream()));
            BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));

            // Generate timestamp-based log file
            String timestamp = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss").format(new Date());
            FileWriter logWriter = new FileWriter("chat_log_" + timestamp + ".txt");
            BufferedWriter logBuffer = new BufferedWriter(logWriter);

            String str1, str2;

            System.out.println("=====================================");
            System.out.println("Chat Messenger application started...");
            System.out.println("=====================================");

            while ((str1 = br1.readLine()) != null) {
                System.out.println("Client: " + str1);
                
                // Write chat logs
                logBuffer.write("Client: " + str1);
                logBuffer.newLine();
                
                System.out.print("SERVER: ");
                str2 = br2.readLine();

                // Write server response to logs
                logBuffer.write("Server: " + str2);
                logBuffer.newLine();
                logBuffer.flush(); // Flush buffer to file
                
                ps.println(str2);
            }

            System.out.println("Thank you for using the Chat Application..");

            // Close resources
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
