package remote;


import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;


public class GoogleService extends UnicastRemoteObject implements IGoogle {
	private static final long serialVersionUID = 1L;
	private List<String> emails = new ArrayList<>();
	
	//Attribute for the Singleton pattern
	public static GoogleService instance;
			
	private GoogleService() throws RemoteException {
		this.initilizeData();
	}
	
	private void initilizeData() {
		
		emails.add("paula");
		emails.add("joseba");

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
	public boolean checkUsuario(String email) throws RemoteException {
		
		boolean result = false;
		for (String e : emails) {
			if(e.equals(email)) {
				result= true;
				System.out.println("Usuario encontrado");
			}
		}
		return result;
	}
}