package pis.hue1;

import java.util.regex.Pattern;

/**
 * Die Klasse stellt die Kodierung und Dekodierung nach dem 
 * Caeser-Verschluesslungsferfahren dar
 * 
 * Die Klasse implementiert das Interface Codec
 * 
 * @author Yannick Dreher 5155125
 * 
 * @version final 1.0 Abgabe
 */
public final class Caesar implements Codec {
	/** Das Loesungswort, nur Buchstaben von 'A' bis 'Z'*/
	String loesung;
	/**
	 * initialisiert die Klassenvariable loesung
	 * @param shift die Laenge davon ist die Anzahl des verschiebens
	 */
	public Caesar(String shift) {
		setzeLosung(shift);
	}
	/**
	 * initalisiert ein Objekt mit leerer Klassenvariable
	 */
	public Caesar() {
		this.loesung = "";
	}
	/**
	 * Kodiert den gegebenen Text mit Hilfe des gesetzen Schluesselwortes nach dem Caeser-Verfahrens
	 * 
	 * @param klartext den zu kodieren Klartext ohne Syntax Vorraussetzungen
	 * 
	 * @return den kodierten Text als String, es wurden nur alle Gross- und Kleinbuchstaben kodiert
	 */
	@Override
	public String kodiere(String klartext) {
		int shift = this.loesung.length();
		String ausgabe="";
		char temp='b';
		for(int i = 0 ; i<klartext.length() ; i++) {
			if((klartext.charAt(i)>=97)&&(klartext.charAt(i)<=122)) {
				temp=(char) (klartext.charAt(i)+shift);
				while(temp>122) {
					temp-=26;
				}
			}else {
				if(klartext.charAt(i)>=65&&klartext.charAt(i)<=90){
					temp=(char) (klartext.charAt(i)+shift);
					while(temp>90) {
						temp-=26;
					}
				}else {
					temp=(char) (klartext.charAt(i));
				}
			}
			
			ausgabe=ausgabe +temp+"";
		}
		
		return ausgabe;
	}
	/**
	 * Dekodiert den gegebenen Text mit Hilfe des gesetzen Schluesselwortes nach dem Caeser-Verfahrens
	 * 
	 * @param geheimtext den zu dekodierenden Geheimtext ohne Syntax Vorraussetzungen
	 * 
	 * @return den dekodierten Text als String, es wurden nur alle Gross- und Kleinbuchstaben dekodiert
	 */
	@Override
	public String dekodiere(String geheimtext) {
		int shift = this.loesung.length();
		String ausgabe="";
		char temp= 0;
		for(int i = 0 ; i<geheimtext.length() ; i++) {
			if((geheimtext.charAt(i)>=97)&&(geheimtext.charAt(i)<=122)) {
				temp=(char) (geheimtext.charAt(i)-shift);
				if(temp<97) {
					temp+=26;
				}
			}else {
				if(geheimtext.charAt(i)>=65&&geheimtext.charAt(i)<=90){
					temp=(char) (geheimtext.charAt(i)-shift);
					if(temp<65) {
						temp+=26;
					}
				}else {
					temp=(char) (geheimtext.charAt(i));
				}
			}
			
			ausgabe=ausgabe +temp+"";
		}
		
		return ausgabe;
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
	 * @param loesung Dieses darf nur Grosse und kleine Buchstaben von 'a' bis 'z' enthalten 
	 * @throws IllegalArgumentException wirft IAE, falls ein leerer schluessel uebergeben wird, oder dieses andere Zeichen ausser große und 
	 * kleine Buchstaben von 'a' bis 'z' enthällt
	 */
	@Override
	public void setzeLosung(String loesung) throws IllegalArgumentException {
		if(loesung == null || loesung.equals("")) {
			throw new IllegalArgumentException("Das ist kein gutes Schluesselwort");
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
