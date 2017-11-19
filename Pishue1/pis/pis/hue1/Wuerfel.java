/**
 * 
 */
package pis.hue1;

/**
 * @author Yannick Dreher 5155125
 *
 */
public class Wuerfel implements Codec {
	@Override
	public String kodiere(String klartext) {
		String schluessel = this.gibLoesung();
		String[][] matrix = new String[klartext.length()/schluessel.length()+2][schluessel.length()];
		String[][] matrixsort = new String[klartext.length()/schluessel.length()+2][schluessel.length()];
		int place = 0;
		for(char charplace = 'a'; charplace!='z'+1; charplace++) {
			for(int i=0; i<(schluessel.length()); i++) {
				if(schluessel.toLowerCase().charAt(i) ==(charplace)) {
					matrix[0][i]=  place+"";
					place++;
					}
				}
		}
		place = 0;
		int spalte = 1;
		for(int i=0 ; i<klartext.length() ; i++) {
			matrix[spalte][place] = "" + klartext.charAt(i);
			place++;
			if(place==klartext.length()) {
				place = 0;
				spalte++;
			}
		}
		place = 0;
		while (place < schluessel.length()) {
			for(int i = place; i < schluessel.length() ; i++) {
				if(Double.parseDouble(matrix[0][i])==place) {
					matrixsort[place] = matrix[i];
					place++;
				}
			}
		
		
		}
		
		String ausgabe ="";
		for(int laufspalte = 0 ; laufspalte <klartext.length()/schluessel.length()+1; laufspalte++) {
			for(int laufzeile = 0 ; laufzeile < schluessel.length() ; laufzeile++) {
				ausgabe = ausgabe + matrixsort[laufspalte][laufzeile];
			}
		}
		
		
		
		return null;
	}
//	@Override
//	public String kodiere(String klartext) {
//		return "klappt";
//	}

	@Override
	public String dekodiere(String geheimtext) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String gibLoesung() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setzeLoesung(String schluessel) throws IllegalArgumentException {

	}

	
	

}
