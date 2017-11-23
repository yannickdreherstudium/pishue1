package pis.hue1;

import java.util.regex.Pattern;

/**
 * Die Klasse stellt die Kodierung und Dekodierung nach dem
 * wurfelverfahren dar
 * 
 * Die Klasse implementiert das Interface Codec
 * 
 * @author Yannick Dreher 5155125
 *
 * @version final 1.0 Abgabe
 */
public final class Wuerfel implements Codec {
	/** Das Loesungswort, nur Buchstaben von 'A' bis 'Z' und mindestens 3 Zeichen */
	String loesung;
	/**
	 * initialisiert die Klassenvariable loesung
	 * @param loesung das Loesungswort
	 */
	public Wuerfel(String loesung) {
		setzeLosung(loesung);
	}

	/**
	 * Kodiert den gegebenen Text mit Hilfe des gesetzen Schluesselwortes nach dem Wuerfelverfahren
	 * 
	 * 1. Das Loesungwort wird durch eine Zahlen Permutation ersetzt und in ein Array[][] geschrieben
	 * 2. Mit dem Klartext das Array auffuellen
	 * 3. Das Array wird anhand der Permutaion in ein neues Array[][] sortiert 
	 * 4. Das Array wird Spaltenweise ausgelesen und der resultierende Text zurueck gegeben
	 * 
	 * @param klartext den zu kodieren Klartext ohne Syntax Vorraussetzungen
	 * 
	 * @return den kodierten Text als String
	 */
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
			matrix[spalte][place] = ""+klartext.charAt(i);
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
		StringBuffer ausgabe = new StringBuffer();
		for(int i = 0 ; i<schluessel.length() ; i++) {
			for(int j = 1 ; j< klartext.length()/schluessel.length()+2 ; j++) {
				if(matrixsort[j][i]!=null) {
					ausgabe.append(matrixsort[j][i]);
				}
			}
		}
		return ausgabe.toString();
	}
	
	/**
	 * Dekodiert den gegebenen Text mit Hilfe des gesetzen Schluesselwortes nach dem Wuerfelverfahren
	 * 
	 * 1. Das Loesungswort wird durch eine Zahlen Permutation ersetzt und in ein Array[][] geschreiben
	 * 2. Die Freizubleibenden-Felder werden markiert
	 * 3. Mit dem Geheimtext wird das Array aufgefuellt 
	 * 4. Zeilenweise ausgelesen und zurueckgegeben
	 * 
	 * @param geheimtext den zu dekodierenden Geheimtext ohne Syntax Vorraussetzungen
	 * 
	 * @return den dekodierten Text als String
	 */
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
			for (int j = 0; j<schluessel.length(); j++) { // j: die Aktuelle spaltezeiger
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
		
		StringBuffer ausgabe = new StringBuffer();
		for(int j =1 ; j<(geheimtext.length()/schluessel.length())+2  ; j++) {
			for(int k = 0 ; k< schluessel.length() ; k++) {
				if(matrix[j][k].equals("leer"))continue;
				ausgabe.append(matrix[j][k]);
			}
		}
		return ausgabe.toString();
	}

	/**
	 * Gibt das Loesungwort wieder
	 * @return das vorher gesetzte Loesungswort, das nur Buchstaben enthaellt, Gross und Kleinschreibung irrelevant
	 */
	@Override
	public String gibLosung() {
		return this.loesung;
	}
	
	/**
	 * Setzt ein Objekt ein Lösungswort
	 * @param loesung Dieses darf nur Grosse und kleine Buchstaben von 'a' bis 'z' enthalten und muss mindestens 3 davon enthalten
	 * @throws IllegalArgumentException wirft IAE, falls ein leerer schluessel uebergeben wird, oder dieses andere Zeichen ausser große und 
	 * kleine Buchstaben von 'a' bis 'z' enthällt, oder weniger als 3 Zeichen lang ist
	 */
	@Override
	public void setzeLosung(String loesung) throws IllegalArgumentException {
		if(loesung == null || loesung.equals("") || loesung.isEmpty()) {
			throw new IllegalArgumentException("Das ist kein gutes Schluesselwort");
		}
		if(loesung.length()<2) {
			throw new IllegalArgumentException("Das Schluesselwort ist zu kurz");
		}
		char[] _loesung = loesung.toLowerCase().toCharArray();
		for(int i= 0 ; i<loesung.length() ; i++) {
			if(Pattern.matches("\\p{Lower}", _loesung[i]+"") == false) {
				throw new IllegalArgumentException("Du darfst nur Buchstaben in den Schluesseln verwenden!");
			}
		}
		this.loesung=loesung;
	}

}