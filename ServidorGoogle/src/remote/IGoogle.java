package remote;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IGoogle extends Remote {
	public boolean checkUsuario(String email) throws RemoteException;
}
