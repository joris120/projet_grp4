package projet;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		Donjon d = new Donjon(1);
 		System.out.println(d);
 		Personnage p = new Personnage(1);
 		System.out.println(p);
 		p.ramasser();
 		System.out.println(p);
 		System.out.println(p.getInventaire());
 		
 		
 		Scanner sc = new Scanner(System.in);
 		
 		
 		System.out.println("A votre tour");
 		p.deplacer(sc.nextLine());
 		if(sc.nextLine().equals("u")) {
 			p.utiliser();
 		}
	}
	

}
