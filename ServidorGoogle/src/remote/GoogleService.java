package remote;


import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class GoogleService extends UnicastRemoteObject implements IGoogle {
	private static final long serialVersionUID = 1L;
	private Map<String, String> usuarios = new HashMap<>();
	
	//Attribute for the Singleton pattern
	public static GoogleService instance;
			
	private GoogleService() throws RemoteException {
		this.initilizeData();
	}
	
	private void initilizeData() {
		
		usuarios.put("joseba", "joseba");
		usuarios.put("paula", "paula");

	}
	
	public static GoogleService getInstance() {
		if (instance == null) {
			try {
				instance = new GoogleService();
			} catch(Exception ex) {
				System.err.println("  # Error initializing service(): " + ex.getMessage());
			}
		}
		
		return instance;
	}	
	
	@Override
	public boolean checkUsuario(String email, String contrasenya) throws RemoteException {
		
		if(usuarios.containsKey(email)) {
			if(usuarios.get(email).matches(contrasenya)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean checkEmail(String email) throws RemoteException {
		if(usuarios.containsKey(email)) {
			return true;
		}
		return false;
	}
}