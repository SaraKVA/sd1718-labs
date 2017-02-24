package example;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ConnectException;
import java.net.Socket;


public class SocketClient {

    @SuppressWarnings("deprecation")
	public static void main( String[] args ) throws IOException {
        // Check arguments
        if (args.length <= 2) {
            System.err.println("Argument(s) missing!");
            System.err.printf("Usage: java %s host port file%n", SocketClient.class.getName());
            return;
        }

        String host = args[0];
        // Convert port from String to int
        int port = Integer.parseInt(args[1]);
        // Concatenate arguments using a string builder
        StringBuilder sb = new StringBuilder();
        for (int i = 2; i < args.length; i++) {
            sb.append(args[i]);
            if (i < args.length-1) {
                sb.append(" ");
            }
        }
        String text = sb.toString();
        
        try{
        
	        // Create client socket
	        Socket socket = new Socket(host, port);
	        System.out.printf("Connected to server %s on port %d %n", host, port);
	
	        // Create stream to send data to server
	        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
	
	        // Send text to server as bytes
	        out.writeBytes(text);
	        out.writeBytes("\n");
	        System.out.println("Sent text: " + text);
	        
	  
	        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
	        System.out.println("waiting for server...");
	        System.out.println(in.readLine());
	        
	        // Close client socket
	        socket.close();
	        System.out.println("Connection closed");
	        
        }catch (ConnectException e){
        	System.err.println("Caught exception: " + e);
            System.err.println("Rethrowing");
            throw e;
        }
    
    }
}
