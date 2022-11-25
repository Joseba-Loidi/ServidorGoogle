package server;

import java.rmi.Naming;

import remote.GoogleService;
import remote.IGoogle;

public class CurrecyExchangeServer {

	public static void main(String[] args) {
		if (System.getSecurityManager() == null) {
			System.setSecurityManager(new SecurityManager());
		}

		String name = "//" + args[0] + ":" + args[1] + "/" + args[2];		
		
		try {
			IGoogle remoteObject = GoogleService.getInstance();			
			Naming.rebind(name, remoteObject);
			System.out.println(" * ServidorGoogle '" + name + "' started!!");
		} catch (Exception ex) {
			System.out.println(" # ServidorGoogle: " + ex.getMessage());
			ex.printStackTrace();
		}

	}
}