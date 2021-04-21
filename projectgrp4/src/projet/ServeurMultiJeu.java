package projet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.ArrayList;

public class ServeurMultiJeu extends Thread {
	private ArrayList<Socket> socket;
	private ArrayList<PrintStream> out;
	private ArrayList<BufferedReader> in;
	
	public ServeurMultiJeu(Socket s) throws IOException {
		socket.add(s);
		in.add(new BufferedReader(new InputStreamReader(s.getInputStream())));
		out.add(new PrintStream (new PrintStream(s.getOutputStream())));
	}
	
	public void run() {
		try {
			
			Donjon donjon = new Donjon();
			
			Personnage p = new Personnage();
			
			
			
			for(int i = 0; i < out.size();i++) {
				out.get(i).println(p.AffichageMap());
			}
			
			
			
			while(!(p.getGagne())) {
				ArrayList<String> message = new ArrayList();
				for(int i = 0; i < in.size();i++) {
					message.add(in.get(i).readLine()); 
				}
				for(int i = 0; i < socket.size();i++) {
					if(message.get(i).equals("z")||message.get(i).equals("q")||message.get(i).equals("s")||message.get(i).equals("d")||message.get(i).equals("r")||message.get(i).equals("u")){
						if(message.get(i).equals("z")||message.get(i).equals("q")||message.get(i).equals("s")||message.get(i).equals("d")) {
					 		if(p.deplacementPossible(message.get(i))) {
					 			p.deplacer(message.get(i));
					 			if(p.Piege()) {
					 				if(p.mort()) {
					 					out.get(i).println(p.AffichageMap()+"wVous n'avez plus de vie.wVous vous reveillez ailleurs ...");
					 				}else {
					 					out.get(i).println(p.AffichageMap()+"wIl y a un piege. wVous avez maintenant "+p.getHp()+" points de vie. wwA votre tour : ");
					 				}
						 			
						 		}else {
						 			out.get(i).println(p.AffichageMap()+"wwA votre tour : ");
						 		}
					 		}else {
					 			out.get(i).println(p.AffichageMap()+"wLa sortie n'est pas par ici ...wwA votre tour : ");
					 		}
					 		
					 		}else if(message.equals("u")) {
					 			if(p.getInventaire()==0) {
					 				out.get(i).println(p.AffichageMap()+"wVous n'avez pas de potion en stock.wwA votre tour : ");
					 			} else {
					 				p.utiliser();
					 				out.get(i).println(p.AffichageMap()+"wPotion utilisee. wVous avez "+p.getHp()+" points de viewwA votre tour : ");
					 			}
					 	 	}else if(message.equals("r")) {
					 	 		if(p.getInventaire() < 5) {
					 	 			p.ramasser();
						 	 		out.get(i).println(p.AffichageMap()+"wPotion ramasseewVoues avez "+p.getInventaire()+ " potionswwA votre tour : ");
					 	 		} else {
					 	 			if(p.getInventaire() >=5) {
					 					out.get(i).println(p.AffichageMap()+"wL'inventaire est déjà plein.wwA votre tour : ");
					 				} else {
					 					out.get(i).println(p.AffichageMap()+"wPas d'objet à ramasser.wwA votre tour : ");
					 				}
					 	 		}
					 	 	}
						}else {
							out.get(i).println(p.AffichageMap()+"wwA votre tour : ");
						}
				}
				
					p.isWin();
				}
			for(int i = 0; i < out.size();i++) {
				out.get(i).println("Bravo !wVous avez gagne !wVous etes mort "+p.nbMorts+" fois.");
			}
			for(int i = 0; i < socket.size();i++) {
				socket.get(i).close();
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
