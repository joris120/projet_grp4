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
		
		while(true) {
			System.out.println("a votre tour : ");
			String k = sc.nextLine();
			out.println(k);
			
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
			
			
			
			
			
			
		}
		
		
		}
}
