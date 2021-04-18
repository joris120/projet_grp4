package projet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

public class ServeurJeu extends Thread {
	
	private Socket socket;
	private PrintStream out;
	private BufferedReader in;
	
	public ServeurJeu(Socket s){
		this.socket = s;
	}
	
	public void run() {
		try {
			in = new BufferedReader(
		          new InputStreamReader(socket.getInputStream())
		          );
			
			out = new PrintStream(socket.getOutputStream());
			Personnage p = new Personnage();
			
			
			
			
			
			out.println(p.AffichageMap());
			
			while(true) {
				String message = in.readLine();
			 	if(message.equals("z")||message.equals("q")||message.equals("s")||message.equals("d")) {
			 		if(p.deplacementPossible(message)) {
			 			p.deplacer(message);
			 		}else {
			 			out.println("La sortie n'est pas par ici ...");
			 		}
			 		if(p.IlYAUnMur()) {
			 			out.print("Il y a un mur");
			 		}
			 		if(p.Piege()) {
			 			out.println("il y a un piege");
			 		}
			 		}else if(message.equals("u")) {
			 	 		p.utiliser();
			 	 	}else if(message.equals("r")) {
			 	 		p.ramasser();
			 	 	}
			 		out.println(p.AffichageMap());
				}
				
				
			}catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (HpException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
		}
	}
