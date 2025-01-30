import java.net.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

class Client {
    public static void main(String[] args) {
        try {
            System.out.println("Client application is running...");
            System.out.println("--------------------------------");

            System.out.println("Connecting to server...");
            Socket sobj = new Socket("localhost", 2100); // Connect to server
            System.out.println("Connection established with the server..");

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

            while (!(str1 = br2.readLine()).equals("end")) {
                ps.println(str1);

                // Write chat logs
                logBuffer.write("Client: " + str1);
                logBuffer.newLine();

                str2 = br1.readLine();
                System.out.println("Server: " + str2);
                
                // Write server response to logs
                logBuffer.write("Server: " + str2);
                logBuffer.newLine();
                logBuffer.flush(); // Flush buffer to file

                System.out.println("-------------------------------------");
                System.out.print("CLIENT: ");
            }

            System.out.println("Thank you for using the Chat Application..");

            // Close resources
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
