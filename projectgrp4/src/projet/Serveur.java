package projet;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Serveur {
private static int PORT = 6113;
	
	public Serveur(){
	
	}
	
	public static void main(String[] args) {
		// Premier message
		System.out.println("Serveur démarré");
		ServerSocket s = null;
		try {
		
			//Creation socket serveur
			s = new ServerSocket(PORT);
		}
		catch(IOException e){
			e.printStackTrace();
		}
		while(true){
			try {
				//en attente d'une connexion avec un client:  
				Socket client = s.accept();
			
				//création du nouveau thread en passant le socket comme parametre
				ServeurJeu donjon = new ServeurJeu(client);
				//démarrage 
				donjon.start();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
	
	
}
}
