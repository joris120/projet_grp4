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

	
		Scanner sc = new Scanner(System.in);
		while(!(p.getGagne())) {
		 	System.out.println(in.readLine());
		 	System.out.println("A votre tour :");
		 	String k = sc.nextLine();
		 	out.println(k);
		 	
			sc.close();
			socket.close();

	}

}
