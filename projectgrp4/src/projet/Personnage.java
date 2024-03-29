package projet;

public class Personnage {
	private int hp = 10;
	private int inventaire = 0;
	private int i = (int) (Math.random()*(15));
	private int j = (int) (Math.random()*(15));
	private String[][]mapJoueur = new String[15][15];
	private boolean gagne = false;
	public static int nbMorts = 0;
	
	Donjon d = new Donjon();
	
	public Personnage() {
		for(int i = 0; i< 15; i++) {
 			for(int j = 0; j < 15; j++) {
 				mapJoueur[i][j]="?";
 			}
 		}
		mapJoueur[this.getI()][this.getJ()]="X";
	}
	
	public boolean getGagne() {
		return gagne;
	}
	public void setGagne(boolean b) {
		this.gagne = b;
	}
	
	public int getI() {
		return i;
	}
	public int getJ() {
		return j;
	}
	public void setI(int i) {
		this.i = i;
	}
	public void setJ(int j) {
		this.j = j;
	}
	
	
	public String[][] getMap() {
		return mapJoueur;
	}
	
	public int getHp() {
		return hp;
	}
	public void setHp(int hp) throws HpException {
		if(this.getHp()+hp>=0 && this.getHp()+hp<=10) {
			this.hp= this.getHp()+hp;
		} else {
			throw new HpException();
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
		if(inventaire < 5 && d.getMap()[this.getI()][this.getJ()].equals("P")) {
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
	
	public void utiliser() throws HpException {
		if(this.inventaire != 0 && this.getHp()<10) {
			this.setHp(1);
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
					if(this.getI() == 0) {
						b = false;
					}else {
						i-=1;
						b = false;
					}
				}else if(r.equals("q")) {
					if(this.getJ() == 0) {
						b = false;
					} else {
						j-=1;
						b = false;
					}
				}else if(r.equals("s")) {
					if(this.getI() == 14) {
						b = false;
					}else {
						i+=1;
						b = false;
					}
				} else {
					if(this.getI() == 14) {
						b = false;
					} else {
						j += 1;
						b = false;
					}
				}
			}
			if(d.getMap()[this.getI()][this.getJ()].equals("#")) {
				this.getMap()[this.getI()][this.getJ()]="#";
				i =k;
				j=l;
			}
	}
	
	
	public void isWin() {
		if(d.getMap()[this.getI()][this.getJ()].equals("V")) {
			this.setGagne(true);
		}
	}
	
	public boolean deplacementPossible(String r) {
		boolean b = true;
		
			if(r.equals("z")) {
				if(this.getI() == 0) {
					b = false;
				}
			}else if(r.equals("q")) {
				if(this.getJ() == 0) {
					b = false;
				} 
			}else if(r.equals("s")) {
				if(this.getI() == 14) {
					b = false;
				}
			} else {
				if(this.getJ() == 14) {
					b = false;
				} 
			
		}
		return b;
	}
	
	
	
	public boolean Piege() throws HpException {
		if(d.getMap()[this.getI()][this.getJ()].equals("~")) {
			this.setHp(-1);
			return true;
		}
		return false;
		
	}
	
	public boolean mort() throws HpException {
		if(this.getHp()==0) {
			this.setI((int) (Math.random()*(15)));
			this.setJ((int) (Math.random()*(15)));
			this.setHp(10);
			this.nbMorts += 1;
			return true;
		}
		return false;
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
 			r+="w";
 		}
 		return r;
		
	}
	public String Lecture(String message2) {
		String map2 = "";
		for(int i = 0; i<message2.length();i++) {
			if(message2.substring(i, i+1).equals("w")) {
				map2 += "\n";
			}else {
				map2 += message2.charAt(i);
			}
		}
		return map2;
	}
}
