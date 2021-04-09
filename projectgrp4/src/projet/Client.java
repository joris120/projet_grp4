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
		
		System.out.println(in.readLine());
		Scanner scanner = new Scanner (System.in);
		
		//lecture du message initial du serveur
		//System.out.println(in.readLine());
		
		//5 requêtes
		for(int i=0;i<5;i++){
			out.println(scanner.nextLine());
			System.out.println(in.readLine());
		}
		
		scanner.close();
		socket.close();

	}

}
