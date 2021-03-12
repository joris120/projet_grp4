package projet;

public class Personnage {
	private int hp = 10;
	private int inventaire;
	private int i = 7;
	private int j = 8;
	private String[][]mapObjet = new String[15][15];
	
	public Personnage(int n) {
		for(int i = 0; i< 15; i++) {
 			for(int j = 0; j < 15; j++) {
 				mapObjet[i][j]=",";
 			}
 		}
 		for(int i = 0; i< 4; i++) {
 			for(int j = 0; j < 4; j++) {
 				if(mapObjet[i][j].equals(",")) {
 					mapObjet[(int) (Math.random()*(15))][(int) (Math.random()*(15))]="~";
 				}
 				if(mapObjet[i][j].equals(",")) {
 					mapObjet[(int) (Math.random()*(15))][(int) (Math.random()*(15))]="P";
 				}
 				if(mapObjet[i][j].equals(",")) {
 					mapObjet[(int) (Math.random()*(15))][(int) (Math.random()*(15))]="#";
 				}
 			}
 		}
 		for(int i = 0; i< 1; i++) {
 			for(int j = 0; j < 1; j++) {
 				mapObjet[(int) (Math.random()*(15))][(int) (Math.random()*(15))]="V";
 			}
 		}
	}
	
	
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
		if(inventaire < 5 && mapObjet[i][j].equals("P")) {
			inventaire += 1;
			if(mapObjet[i][j].equals(",")) {
					mapObjet[(int) (Math.random()*(15))][(int) (Math.random()*(15))]="P";
				}
		} else {
			System.err.println("L'inventaire est déjà plein.");
		}
	}
	
	
}
