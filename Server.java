import java.net.*;
import java.io.*; 

class Server
{
    public static void main(String Arg[]) throws Exception
    {
        System.out.println("Server application is running...");
        System.out.println("--------------------------------");

        ServerSocket ssobj = new ServerSocket(2100);
        System.out.println("Waiting for client at port number 2100");

        Socket sobj = ssobj.accept();   // Accept the request from the client
        System.out.println("Connection established with the client..");
        System.out.println("");

        PrintStream ps = new PrintStream(sobj.getOutputStream()); 
        BufferedReader br1 = new BufferedReader(new InputStreamReader(sobj.getInputStream()));
        BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));
        String str1, str2;

        System.out.println("=====================================");
        System.out.println("Chat Messenger application started...");
        System.out.println("=====================================");
        System.out.println("");

        while((str1 = br1.readLine()) != null)
        {
            System.out.println("client : "+str1);
            System.out.print("SERVER : ");
            str2 = br2.readLine();
            System.out.println("-------------------------------------");
            ps.println(str2);
        }
        System.out.println("Thank you for using the Chat Application..");
    }
}