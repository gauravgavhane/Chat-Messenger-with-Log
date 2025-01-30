import java.net.*;
import java.io.*;

class Client {
    public static void main(String Arg[]) {
        try {
            System.out.println("Client application is running...");
            System.out.println("--------------------------------");

            System.out.println("Connecting .....");
            Socket sobj = new Socket("localhost", 2100); // Request to server
            System.out.println("Connection established with the server..");

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

            while (!(str1 = br2.readLine()).equals("end")) {
                ps.println(str1);

                // Writing chat logs
                logBuffer.write("Client: " + str1);
                logBuffer.newLine();
                
                str2 = br1.readLine();
                System.out.println("Server: " + str2);
                
                // Writing server response to logs
                logBuffer.write("Server: " + str2);
                logBuffer.newLine();
                logBuffer.flush();
                
                System.out.println("-------------------------------------");
                System.out.print("CLIENT : ");
            }

            System.out.println("Thank you for using the Chat Application..");

            // Closing resources
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

