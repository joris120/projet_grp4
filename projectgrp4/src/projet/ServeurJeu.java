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

			String k = in.readLine();
			if(k.equals("z")||k.equals("q")||k.equals("s")||k.equals("d")) {
		 		p.deplacer(k);
		 		p.piege();
		 		}else if(k.equals("u")) {
		 	 		p.utiliser();
		 	 	}else if(k.equals("r")) {
		 	 		p.ramasser();
		 	 	}	
		 	}
			
			socket.close();	
			} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		}
	}
