package projet;

public class Test {

	public static void main(String[] args) {
		Donjon d = new Donjon(1);
 		System.out.println(d);
 		Personnage p = new Personnage(1);
 		System.out.println(p);
 		p.ramasser();
 		System.out.println(p);
 		System.out.println(p.getInventaire());
	}
	

}
