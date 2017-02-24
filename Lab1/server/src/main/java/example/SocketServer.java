package example;


import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class SocketServer 
{
    public static void main( String[] args ) throws IOException, ParseException {
        // Check arguments
        if (args.length < 1) {
            System.err.println("Argument(s) missing!");
            System.err.printf("Usage: java %s port%n", SocketServer.class.getName());
            return;
        }

        // Convert port from String to int
        int port = Integer.parseInt(args[0]);

        try{
	        // Create server socket
	        ServerSocket serverSocket = new ServerSocket(port);
	        System.out.printf("Server accepting connections on port %d %n", port);
	
	        // wait for and then accept client connection
	        // a socket is created to handle the created connection
	        Socket clientSocket = serverSocket.accept();
	        System.out.printf("Connected to client %s on port %d %n",
	            clientSocket.getInetAddress().getHostAddress(), clientSocket.getPort());
	
	        // Create stream to receive data from client
	        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
	
	        // Receive data until client closes the connection
	        String response = in.readLine();
	        System.out.printf("Client: '%s'%n", response);
	
	        //send confirmation message
	        DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());
	        out.writeBytes("server confirmation: OK\n");
	        System.out.println("confirmation sent");
	        
	        
	        BufferedReader in2 = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
	        
	        String clientMsg = in2.readLine();
	        System.out.println("Client: " + clientMsg);
	        
	        String[] buffer = clientMsg.split(" ");
	        int year = Integer.parseInt(buffer[1]);
	        
	        Calendar cal = Calendar.getInstance();
	        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	        cal.setTime(sdf.parse(buffer[0]));
	        cal.add(Calendar.YEAR, year);
	        
	        System.out.println(cal.getTime());
	        // Close connection to current client
	        clientSocket.close();
	        System.out.println("Closed connection with client");
	
	        // Close server socket
	        serverSocket.close();
	        System.out.println("Closed server socket");     
	        
        } catch (IllegalArgumentException e){
        	System.err.println("Caught exception: " + e);
            System.err.println("Rethrowing");
            throw e;
        }
    }
}
