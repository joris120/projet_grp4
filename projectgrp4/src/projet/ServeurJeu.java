package projet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.ArrayList;
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
			
			while(!(p.getGagne())) {
				String message = in.readLine();
				if(message.equals("z")||message.equals("q")||message.equals("s")||message.equals("d")||message.equals("r")||message.equals("u")){
					if(message.equals("z")||message.equals("q")||message.equals("s")||message.equals("d")) {
				 		if(p.deplacementPossible(message)) {
				 			p.deplacer(message);
				 			if(p.Piege()) {
				 				if(p.mort()) {
				 					out.println(p.AffichageMap()+"wVous n'avez plus de vie.wVous vous reveillez ailleurs ...");
				 				}else {
				 					out.println(p.AffichageMap()+"wIl y a un piege. wVous avez maintenant "+p.getHp()+" points de vie. wwA votre tour : ");
				 				}
					 			
					 		}else {
					 			out.println(p.AffichageMap()+"wwA votre tour : ");
					 		}
				 		}else {
				 			out.println(p.AffichageMap()+"wLa sortie n'est pas par ici ...wwA votre tour : ");
				 		}
				 		
				 		}else if(message.equals("u")) {
				 			if(p.getInventaire()==0) {
				 				out.println(p.AffichageMap()+"wVous n'avez pas de potion en stock.wwA votre tour : ");
				 			} else {
				 				p.utiliser();
				 				out.println(p.AffichageMap()+"wPotion utilisee. wVous avez "+p.getHp()+" points de viewwA votre tour : ");
				 			}
				 	 	}else if(message.equals("r")) {
				 	 		if(p.getInventaire() < 5) {
				 	 			p.ramasser();
					 	 		out.println(p.AffichageMap()+"wPotion ramasseewVoues avez "+p.getInventaire()+ " potionswwA votre tour : ");
				 	 		} else {
				 	 			if(p.getInventaire() >=5) {
				 					out.println(p.AffichageMap()+"wL'inventaire est déjà plein.wwA votre tour : ");
				 				} else {
				 					out.println(p.AffichageMap()+"wPas d'objet à ramasser.wwA votre tour : ");
				 				}
				 	 		}
				 	 	}
					}else {
						out.println(p.AffichageMap()+"wwA votre tour : ");
					}
					p.isWin();
				}
			out.println("Bravo !wVous avez gagne !wVous etes mort "+p.nbMorts+" fois.");
			socket.close();
			
				
				
				
				
			}catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (HpException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
		}
	}
