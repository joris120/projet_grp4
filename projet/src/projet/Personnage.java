package projet;

public class Personnage {
	private int hp = 10;
	private int inventaire;
	
	
	public int getHp() {
		return hp;
	}
	public void setHp(int hp) {
		if(hp <=10 && hp>=0) {
			this.hp=hp;
		} else {
			System.err.println("");
		}
	}
	
	public int getInventaire() {
		return inventaire;
	}
	
	public void ramasser() {
		if(inventaire < 5) {
			inventaire += 1;
		} else {
			System.err.println("L'inventaire est déjà plein.");
		}
	}
	
	
}
