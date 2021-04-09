package projet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
	
private static BufferedReader in;
private static PrintStream out;
	
public static void main (String [] args) throws UnknownHostException, IOException, HpException {
		Socket socket= new Socket ("127.0.0.1", 6113);
		
		System.out.println("Bienvenue");
		
		in = new BufferedReader (new InputStreamReader(socket.getInputStream()));
		out = new PrintStream(socket.getOutputStream());
		
		
		
		Personnage p = new Personnage();
		
		
		out.println(p.AffichageMap());
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
			socket.close();

	}

}
