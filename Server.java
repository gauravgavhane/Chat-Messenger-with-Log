import java.net.*;
import java.io.*;

class Server {
    public static void main(String Arg[]) {
        try {
            System.out.println("Server application is running...");
            System.out.println("--------------------------------");

            ServerSocket ssobj = new ServerSocket(2100);
            System.out.println("Waiting for client at port number 2100");

            Socket sobj = ssobj.accept(); // Accept the request from the client
            System.out.println("Connection established with the client..");

            PrintStream ps = new PrintStream(sobj.getOutputStream());
            BufferedReader br1 = new BufferedReader(new InputStreamReader(sobj.getInputStream()));
            BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));

            // Log file setup
            FileWriter logWriter = new FileWriter("chat_log.txt", true);
            BufferedWriter logBuffer = new BufferedWriter(logWriter);

            String str1, str2;

            System.out.println("=====================================");
            System.out.println("Chat Messenger application started...");
            System.out.println("=====================================");

            while ((str1 = br1.readLine()) != null) {
                System.out.println("Client: " + str1);
                
                // Writing chat logs
                logBuffer.write("Client: " + str1);
                logBuffer.newLine();
                
                System.out.print("SERVER : ");
                str2 = br2.readLine();
                
                // Writing server response to logs
                logBuffer.write("Server: " + str2);
                logBuffer.newLine();
                logBuffer.flush();
                
                ps.println(str2);
            }

            System.out.println("Thank you for using the Chat Application..");

            // Closing resources
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

