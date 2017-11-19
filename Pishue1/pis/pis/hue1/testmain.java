package pis.hue1;

public class testmain {

	public static void main(String[] args) {
		test("SCHWARZWALD","Elefantenbroetcheneiersalatgedenkort");

	}
	public static void test(String keywort, String code) {
		String[][] matrix = new String[code.length()/keywort.length()+2][keywort.length()];
		int place = 0;
		for(char charplace = 'a'; charplace!='z'+1; charplace++) {
			for(int i=0; i<(keywort.length()); i++) {
				if(keywort.toLowerCase().charAt(i) ==(charplace)) {
					matrix[0][i]=  place+"";
					place++;
					}
				}
		}
		place = 0;
		int spalte = 1;
		for(int i=0 ; i<code.length() ; i++) {
			matrix[spalte][place] = "" + code.charAt(i);
			place++;
			if(place==keywort.length()) {
				place = 0;
				spalte++;
			}
		}
		
		
		
		
		
		for(int j = 0 ; j<(code.length()/keywort.length()+2) ; j++) {
			for(int i=0; i<keywort.length();i++) {
				System.out.print(matrix[j][i]+" ");
			}
			System.out.print("\n");
		}
	}
}
