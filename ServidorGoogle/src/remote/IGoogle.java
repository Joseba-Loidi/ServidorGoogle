package remote;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IGoogle extends Remote {
	public boolean checkUsuario(String email,String contrasenya) throws RemoteException;
	public boolean checkEmail(String email) throws RemoteException;
}
