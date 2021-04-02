package projet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

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
			out.println("Nouvelle partie");
			
		socket.close();
		
		
		
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}