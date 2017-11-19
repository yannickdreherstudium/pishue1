package pis.hue1;


public class testmain {

	public static void main(String[] args) {
		test("Notebook","hallodashieristeinlangerbeispieltextumdasverfahrenzuzeigen");

	}
	public static void test(String schluessel, String klartext) {
		int place = 0;
		String[][] matrix = new String[klartext.length()/schluessel.length()+2][schluessel.length()];
		String[][] matrixsort = new String[klartext.length()/schluessel.length()+2][schluessel.length()];
		
		for(char charplace = 'a'; charplace!='z'+1; charplace++) {
			for(int i=0; i<(schluessel.length()); i++) {
				if(schluessel.toLowerCase().charAt(i) ==(charplace)) {
					matrix[0][i]= place+"";
					place++;
					}
				}
		}
		
		place = 0;
		int spalte = 1;
		for(int i=0 ; i<klartext.length() ; i++) {
			matrix[spalte][place] = "" + klartext.charAt(i);
			place++;
			if(place==schluessel.length()) {
				place = 0;
				spalte++;
				
			}
		}

		for(int j = 0 ; j<(klartext.length()/schluessel.length()+2) ; j++) {
			for(int i=0; i<schluessel.length();i++) {
				System.out.print(matrix[j][i]+" ");
			}
			System.out.print("\n");
		}
		System.out.print("\n");
		
		place = 0;
		while (place < schluessel.length()) {
			System.out.print(place);
			for(int i = place; i < schluessel.length() ; i++) {
				if(Integer.parseInt(matrix[0][i])==place) {
					matrixsort[place] = matrix[i];
					place++;
				}
			}
		}
		for(int j = 0 ; j<(klartext.length()/schluessel.length()+2) ; j++) {
			for(int i=0; i<schluessel.length();i++) {
				System.out.print(matrixsort[j][i]+" ");
			}
			System.out.print("\n");
		}
	}
}
