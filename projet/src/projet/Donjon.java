package projet;

public class Donjon {
	private String[][]map = new String[15][15];
	

 	public Donjon(int n) {
 		for(int z = 0; z <n; z++) {
 			for(int i = 0; i<15;i++) {
 	 			for(int j = 0; j<15;j++) {
 	 				map[i][j]="?";
 	 			}
 	 		}
 		}
 		
 		
 		

 		
 	}

 	public String[][] getMap() {
 		return map;
 	}

 	public String toString() {
 		String r = "";
 		for (int i = 0; i < 15; i++) {
 			for(int j = 0; j<15;j++) {
 				r += map[i][j];
 			}
 			r+="\n";
 		}
 		return r;
 	}

}
