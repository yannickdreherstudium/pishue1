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
		String schluessel = this.gibLosung();
		String[][] matrix = new String[geheimtext.length()/schluessel.length()+2][schluessel.length()];
		
		int place = 0;
		for(char charplace = 'a'; charplace!='z'+1; charplace++) {
			for(int i=0; i<(schluessel.length()); i++) {
				if(schluessel.toLowerCase().charAt(i) ==(charplace)) {
					matrix[0][i]= place+"";
					place++;
					}
				}
		}
		int empty = ((geheimtext.length()/schluessel.length())+1)*schluessel.length()-geheimtext.length();
		for(int i = 0 ; i<empty ; i++) {
			matrix[geheimtext.length()/schluessel.length()+1][schluessel.length()-i-1] = "leer";
		}
		
		int zeile = 1;
		int i=0;
		int emptycount=0;
		while (i<geheimtext.length()) {
			for (int j = 0; j< (geheimtext.length()/schluessel.length())+2; j++) { // j: die Aktuelle spaltezeiger
				for(place = 0; place<schluessel.length(); place++) { //place ist die zu durchsuchende spalte
					if(Integer.parseInt(matrix[0][place])==j) { // falls der aktuelle zeiger auf der aktuell durchsuchten spalte ist, wird diese spalte befüllt
						while(i<((geheimtext.length()/schluessel.length())+1)*(j+1)-emptycount) { 
							/* 
							 * die abruchbedingung, sobald die spalte voll ist
							 * nämlich soll die aktuelle buchstabenanzahl kleiner als die spaltenanzahl mal die aktuelle spalte
							 * allerdings muss noch die anzhal der bisher freigelassen Zahlen abgezogen werden, da dort ja kein Buchstabe gesetzt wurde,
							 * da diese ja frei beliben mussten und wir keineen Buchstaben verlieren
							 */
							if(matrix[zeile][place]!= "leer") { // und zwar nur, wenn das aktuelle feld nicht leer ist 
								matrix[zeile][place] = "" + geheimtext.charAt(i);
								zeile++;
								i++;
								if(zeile==(geheimtext.length()/schluessel.length())+2) {
									zeile = 1;
									place++;
								}
							}else {
							zeile = 1;
							place++;
							emptycount++;
							break;
							}
						}
					}
				}
			}
		}
		
		String ausgabe = "";
		for(int j =1 ; j<(geheimtext.length()/schluessel.length())+2  ; j++) {
			for(int k = 0 ; k< schluessel.length() ; k++) {
				if(matrix[j][k].equals("leer"))continue;
				ausgabe = ausgabe +matrix[j][k];
			}
		}
		return ausgabe;
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
