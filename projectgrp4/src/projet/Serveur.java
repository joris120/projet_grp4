package projet;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Serveur {
private static int PORT = 6113;
	
	private static ArrayList<ServeurJeu> multijoueur = new ArrayList<>();
	
	
	public static void main(String[] args) throws IOException {
		// Premier message
		System.out.println("Serveur démarré");
		ServerSocket s = new ServerSocket(PORT);
		
		while(true){
			try {
				//en attente d'une connexion avec un client:  
				Socket client = s.accept();
				ServeurJeu clientThread = new ServeurJeu(client);
				multijoueur.add(clientThread); 
				
			
				//création du nouveau thread en passant le socket comme parametre
				//ServeurJeu donjon = new ServeurJeu(client);
				//ServeurMultiJeu donjon = new ServeurMultiJeu(client);
				//démarrage 
				for(int i = 0;i< multijoueur.size(); i++) {
					multijoueur.get(i).start();
				}
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		}
	
	
}
}
