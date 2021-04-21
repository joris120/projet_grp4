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
		
		
		in = new BufferedReader (new InputStreamReader(socket.getInputStream()));
		out = new PrintStream(socket.getOutputStream());
		
		
		System.out.println("Bienvenue.");
		System.out.println("Les commandes sont les suivantes : \n -aller a gauche : q \n -aller a droite : d \n -aller en haut : z \n -aller en bas : s \n -ramasser une potion : r \n -utiliser une potion : u \n");
		System.out.println("Pressez la touche entree pour chaque validation. \n");
		System.out.println("La partie commence : \n");

	
		Scanner sc = new Scanner(System.in);
		String message = in.readLine();
		String map = "";
		for(int i = 0; i<message.length();i++) {
			if(message.substring(i, i+1).equals("w")) {
				map += "\n";
			}else {
				map += message.charAt(i);
			}
		}
		
		System.out.println(map);
		System.out.println("A vous de jouer : ");
		while(true) {
			
			out.println(sc.nextLine());
			
			
			String message2 = in.readLine(); //map
			
			String map2 = "";
			for(int i = 0; i<message2.length();i++) {
				if(message2.substring(i, i+1).equals("w")) {
					map2 += "\n";
				}else {
					map2 += message2.charAt(i);
				}
			}
			System.out.println(map2);
		}
		
		}
}
