/**
 * 
 */
package pis.hue1;

/**
 * @author Yannick Dreher 5155125
 *
 */
public class Wuerfel implements Codec {
	String loesung;
	
	public Wuerfel(String schluessel) {
		setzeLoesung(schluessel);
	}

	@Override
	public String kodiere(String klartext) {
		String schluessel = this.gibLosung();
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

		for(place = 0;  place < schluessel.length(); place++) {
			for(int i = 0; i < schluessel.length() ; i++) {
				if(Integer.parseInt(matrix[0][i])==place) {
					for(int j=0; j<klartext.length()/schluessel.length()+2 ; j++) {
						matrixsort[j][place] = matrix[j][i];
					}
				}
			}
		}
		String ausgabe = "";
		for(int i = 0 ; i<schluessel.length() ; i++) {
			for(int j = 1 ; j< klartext.length()/schluessel.length()+2 ; j++) {
				if(matrixsort[j][i]!=null) {
					ausgabe = ausgabe +matrixsort[j][i];
				}
			}
		}
		return ausgabe;
	}

	@Override
	public String dekodiere(String geheimtext) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String gibLosung() {
		return this.loesung;
	}

	@Override
	public void setzeLoesung(String schluessel) throws IllegalArgumentException {
		this.loesung=schluessel;
	}

	
	

}
