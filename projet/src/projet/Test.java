package projet;

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {
		Donjon d = new Donjon();
 		System.out.println(d);
 		Personnage p = new Personnage("test");
 		
 		
 		Scanner sc = new Scanner(System.in);
 		
 		while(!(d.getMap()[p.getI()][p.getJ()].equals("V"))) {
 			System.out.println(p.AffichageMap());
 			System.out.println("A votre tour :");
 			String k = sc.nextLine();
 			if(k.equals("z")||k.equals("q")||k.equals("s")||k.equals("d")) {
 				p.deplacer(k);
 			}else if(k.equals("u")) {
 	 			p.utiliser();
 	 		}else if(k.equals("r")) {
 	 			p.ramasser();
 	 			System.out.println(p.AffichageMap());
 	 		}
 	 		
 	 		
 		}
 		System.out.println("gagne !");
 		
	}
	

}
