package projet;

public class Personnage {
	private int hp = 10;
	private int inventaire = 10;
	private int i = 9;
	private int j = 6;
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

 		mapObjet[(int) (Math.random()*(15))][(int) (Math.random()*(15))]="V";
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
	public void setInventaire(int inventaire) {
		if(inventaire < 0) {
			System.err.println("l'invetaire est deja vide.");
		} else {
			this.inventaire = inventaire;
		}
	}
	
	public void ramasser() {
		if(inventaire < 5 && mapObjet[i][j].equals("P")) {
			inventaire += 1;
			for(int i = 0; i< 1; i++) {
	 			for(int j = 0; j < 1; j++) {
	 				boolean b = true;
	 				while(b) {
	 					if(mapObjet[i][j].equals(",")&&b) {
	 	 					mapObjet[(int) (Math.random()*(15))][(int) (Math.random()*(15))]="P";
	 	 					b = false;
	 	 				}
	 				}
	 			}
	 		}
			mapObjet[i][j]=",";
		} else {
			if(inventaire >=5) {
				System.err.println("L'inventaire est déjà plein.");
			} else {
				System.err.println("Pas d'objet à ramasser.");
			}
			
		}
	}
	
	public void utiliser() {
		if(this.inventaire != 0) {
			this.setHp(this.getHp()+1);
			this.setInventaire(this.getInventaire()-1);
			System.out.println("Potion utilisee.");
		} else {
			System.err.println("L'inventaire est vide.");
		}
	}
	
	public void deplacer(String r) {
		boolean b = true;
		while(b) {
			if(r.equals("z")) {
				if(j == 0) {
					System.err.println("deplacement impossible");
				}else {
					j-=1;
					b = false;
				}
			}else if(r.equals("q")) {
				if(i == 0) {
					System.err.println("deplacement impossible");
				} else {
					i-=1;
					b = false;
				}
			}else if(r.equals("s")) {
				if(j == 14) {
					System.err.println("deplacement impossible");
				}else {
					j+=1;
					b = false;
				}
			} else {
				if(i == 14) {
					System.err.println("deplacement impossible");
				} else {
					i += 1;
					b = false;
				}
			}
		}
	}
	
	public String toString() {
 		String r = "";
 		for (int i = 0; i < 15; i++) {
 			for(int j = 0; j<15;j++) {
 				r += mapObjet[i][j];
 			}
 			r+="\n";
 		}
 		return r;
 	}
	
	
}
