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
	
	public static void main (String [] args) throws UnknownHostException, IOException {
		Socket socket= new Socket ("127.0.0.1", 6112);
		
		System.out.println("Nouvelle partie.");
		
		in = new BufferedReader (new InputStreamReader(socket.getInputStream()));
		out = new PrintStream(socket.getOutputStream());
		Scanner sc = new Scanner (System.in);
		
		System.out.println(in.readLine());
		
		Scanner nom = new Scanner(System.in);
		
		System.out.println("Saisissez votre nom :");
		
		Personnage p = new Personnage(nom.nextLine());
		nom.close();
		System.out.println("Bienvenue "+p.getName());
		
		while(!(p.getGagne())) {
			System.out.println(p.AffichageMap());
 			System.out.println("A votre tour :");
 			String k = sc.nextLine();
		}
		
		sc.close();
		socket.close();
	}

}
