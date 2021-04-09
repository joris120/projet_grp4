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
			
			//envoi du premier message
			out.println("SERVEUR : en attente de requête");
			
			
			//5 requêtes
			for(int req=0;req<5;req++){
				
		
				String message = in.readLine();
		
				if (message.equals("jouer")){
					
					out.println("partie demarree");
				
					Personnage p = new Personnage("test");
					Scanner sc = new Scanner(System.in);
					while(!(p.getGagne())) {
			 			System.out.println(p.AffichageMap());
			 			System.out.println("A votre tour :");
			 			String k = sc.nextLine();
			 			if(k.equals("z")||k.equals("q")||k.equals("s")||k.equals("d")) {
			 				p.deplacer(k);
			 				p.piege();
			 			}else if(k.equals("u")) {
			 	 			p.utiliser();
			 	 		}else if(k.equals("r")) {
			 	 			p.ramasser();
			 	 		}
			 			
			 		}
					sc.close();
				
				}else{  
					out.println("bug");//+req);
				}
			}
			socket.close();	
			} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			} catch (HpException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
