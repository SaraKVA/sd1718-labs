package ttt;

import java.rmi.*;

public interface TTTService extends Remote{
	
		boolean play(int row, int column, int player) throws RemoteException;
}
