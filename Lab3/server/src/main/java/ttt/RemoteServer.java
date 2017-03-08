package ttt;


import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class RemoteServer {

	public RemoteServer() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws IOException {
		int port = 7888;
		try {
			TTT ttt = new TTT();
			Registry reg = LocateRegistry.createRegistry(port);
			reg.rebind("tttServer", ttt);
			System.out.println("Server Ready");
            System.in.read();
            System.exit(0);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
