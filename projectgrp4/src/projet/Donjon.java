package projet;

public class Donjon {
	private String[][]mapObjet = new String[15][15];
	

 	public Donjon() {
 		for(int i = 0; i< 15; i++) {
 			for(int j = 0; j < 15; j++) {
 				mapObjet[i][j]=",";
 			}
 		}
 		for(int i = 0; i< 4; i++) {
 			for(int j = 0; j < 4; j++) {
 				if(this.getMap()[i][j].equals(",")) {
 	 				mapObjet[(int) (Math.random()*(15))][(int) (Math.random()*(15))]="P";
 	 			}
 			}
 		}
 		for(int i = 0; i< 4; i++) {
 			for(int j = 0; j < 4; j++) {
 				if(this.getMap()[i][j].equals(",")) {
 	 				mapObjet[(int) (Math.random()*(15))][(int) (Math.random()*(15))]="#";
 	 			}
 			}
 		}
 		for(int i = 0; i< 6; i++) {
 			for(int j = 0; j < 6; j++) {
 				if(this.getMap()[i][j].equals(",")) {
 	 				mapObjet[(int) (Math.random()*(15))][(int) (Math.random()*(15))]="~";
 	 			}
 			}
 		}
 		

 		mapObjet[(int) (Math.random()*(15))][(int) (Math.random()*(15))]="V";
 	}

 	public String[][] getMap() {
 		return mapObjet;
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
