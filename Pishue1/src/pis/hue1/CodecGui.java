package pis.hue1;

/**
 * Die Klasse CodecGui stellt die Schnittstelle zwischen der Benutzeroberflaeche und der Kodierung bzw. dekodierung
 * 
 * Sie besitzt 2 Codec-Objekte als Klassenvariablen, die dann mit Hilfe der Methoden koderiert und dekodiert werden können
 * 
 * @author Yannick Dreher 5155125
 * 
 * @version final 1.0 Abgabe 
 */
public final class CodecGui {
	/** Codec-Objekt 1, der gewaehlten Verschluesselung */
	private Codec c1;
	/** Codec-Objekt 2, der gewaehlten Verschluesselung */
	private Codec c2;
	/**
	 * initialisiert die Klassenvariablen mit der gewaehlten Verschluesselung
	 * 
	 * @param _c1 erstes Objekt
	 * @param _c2 zweites Objekt
	 */
	public CodecGui(Codec _c1, Codec _c2){
		c1=_c1;
		c2=_c2;
	}
	/**
	 * ruft die passende Kodiermethode auf
	 * 
	 * falls das zweite Objekt nicht initialisiert wurde, also 'null' ist wird die kodierung nur fuer das erste Objekt aufgerufen
	 * 
	 * @param klartext keine Syntaxvoragben
	 * @return dein kodierten String
	 */
	public String kodiere(String klartext) {
		if(c2 == null) {
			return c1.kodiere(klartext);
		}else {
			return c2.kodiere(c1.kodiere(klartext));
		}
	}
	/**
	 * ruft die passende Dekodiermethode auf
	 * 
	 * falls das zweite Objekt nicht initialisiert wurde, also 'null' ist wird die dekodierung nur fuer das erste Objekt aufgerufen
	 * 
	 * @param geheimtext keine Syntaxvoragben
	 * @return dein dekodierten String
	 */
	public String dekodiere(String geheimtext) {
		if(c2 == null) {
			return c1.dekodiere(geheimtext);
		}else {
			return c1.dekodiere(c2.dekodiere(geheimtext));
		}
	}
	
}
