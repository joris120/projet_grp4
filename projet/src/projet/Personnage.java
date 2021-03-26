package projet;

public class Personnage {
	private String name = "";
	private int hp = 10;
	private int inventaire = 0;
	private int i = (int) (Math.random()*(15));
	private int j = (int) (Math.random()*(15));
	private String[][]mapJoueur = new String[15][15];
	
	Donjon d = new Donjon();
	
	public Personnage(String name) {
		setName(name);
		for(int i = 0; i< 15; i++) {
 			for(int j = 0; j < 15; j++) {
 				mapJoueur[i][j]="?";
 			}
 		}
		mapJoueur[this.getI()][this.getJ()]="X";
	}
	
	public String getName() {
		return name;
	}
	
	public int getI() {
		return i;
	}
	public int getJ() {
		return j;
	}
	
	public void setName(String name) {
		if(name != null) {
			this.name = name;
		} else {
			System.err.println("Nom invalide");
		}
	}
	public String[][] getMap() {
		return mapJoueur;
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
		if(inventaire < 5 && d.getMap()[i][j].equals("P")) {
			inventaire += 1;
			for(int i = 0; i< 1; i++) {
	 			for(int j = 0; j < 1; j++) {
	 				boolean b = true;
	 				while(b) {
	 					if(d.getMap()[i][j].equals(",")&&b) {
	 						d.getMap()[(int) (Math.random()*(15))][(int) (Math.random()*(15))]="P";
	 	 					b = false;
	 	 				}
	 				}
	 			}
	 		}
			d.getMap()[i][j]=",";
			System.out.println("Potion ramassee.");
		} else {
			if(inventaire >=5) {
				System.err.println("L'inventaire est déjà plein.");
			} else {
				System.err.println("Pas d'objet à ramasser.");
			}
			
		}
	}
	
	public void utiliser() {
		if(this.inventaire != 0 && this.getHp()<10) {
			this.setHp(this.getHp()+1);
			this.setInventaire(this.getInventaire()-1);
			System.out.println("Potion utilisee. vous avez "+this.getHp()+" pv.");
		} else {
			if(this.inventaire == 0) {
				System.err.println("L'inventaire est vide.");
			}else {
				System.err.println("Il ne manque aucun point de vie.");
			}
			
		}
	}
	
	public void deplacer(String r) {
			int k = this.getI();
			int l = this.getJ();
			boolean b = true;
			while(b) {
				if(r.equals("z")) {
					if(i == 0) {
						System.err.println("deplacement impossible");
						b = false;
					}else {
						i-=1;
						b = false;
					}
				}else if(r.equals("q")) {
					if(j == 0) {
						System.err.println("deplacement impossible");
						b = false;
					} else {
						j-=1;
						b = false;
					}
				}else if(r.equals("s")) {
					if(i == 14) {
						System.err.println("deplacement impossible");
						b = false;
					}else {
						i+=1;
						b = false;
					}
				} else {
					if(j == 14) {
						System.err.println("deplacement impossible");
						b = false;
					} else {
						j += 1;
						b = false;
					}
				}
				
			}
			if(d.getMap()[this.getI()][this.getJ()].equals("~")) {
				this.setHp(this.getHp()-1);
				System.out.println("vous avez : " + this.getHp()+ " pv");
			} else if(d.getMap()[this.getI()][this.getJ()].equals("#")) {
				this.getMap()[this.getI()][this.getJ()]="#";
				i =k;
				j=l;
				System.err.println("il y a un mur");
			}
		
	}
	
	public String AffichageMap() {
		
		this.getMap()[this.getI()][this.getJ()]="X";
		for (int i = 0; i < 15; i++) {
 			for(int j = 0; j<15;j++) {
 				if(this.getMap()[i][j].equals("X") && (i!=this.getI()|| j!=this.getJ())) {
 					if(d.getMap()[i][j].equals(",")) {
 						this.getMap()[i][j] = " ";
 					}else {
 						this.getMap()[i][j] = d.getMap()[i][j];
 					}
 						
 				}
 			}
 		}
		
		String r = "";
 		for (int i = 0; i < 15; i++) {
 			for(int j = 0; j<15;j++) {
 				r += mapJoueur[i][j];
 			}
 			r+="\n";
 		}
 		return r;
		
	}
	
	public String toString() {
 		String r = "";
 		r+= this.getName() + " a "+ this.getHp()+" points de vie.";
 		return r;
 	}
	
	
}
