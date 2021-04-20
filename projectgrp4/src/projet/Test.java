package projet;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) throws HpException {
		Donjon d = new Donjon();
 		System.out.println(d);
 		Personnage p = new Personnage();
 		
 		
 		Scanner sc = new Scanner(System.in);
 	
 		while(!(p.getGagne())) {
 			System.out.println(p.Lecture(p.AffichageMap()));
 			System.out.println("A votre tour :");
 			String k = sc.nextLine();
 			if(p.deplacementPossible(k)) {
 				if(k.equals("z")||k.equals("q")||k.equals("s")||k.equals("d")) {
 	 				p.deplacer(k);
 	 			}else if(k.equals("u")) {
 	 	 			p.utiliser();
 	 	 		}else if(k.equals("r")) {
 	 	 			p.ramasser();
 	 	 		}
 			}
 			
 			
 		}
	}
	

}
