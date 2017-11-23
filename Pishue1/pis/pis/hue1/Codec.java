package pis.hue1;

/**
 * Das Interface gibt den Aufbau einer Verschluesselungsart vor
 * 
 * @author Yannick Dreher 5155125
 * @version final 1.0 Abgabe
 */
interface Codec {
	/**
	 * Soll den übergebenen Klartext kodieren
	 * 
	 * @param klartext den zu kodierenen Klartext 
	 * @return String: der kodierte Text
	 */
	public String kodiere(String klartext);
	/**
	 * Soll den übergebenen Geheimtext dekodieren
	 * 
	 * @param geheimtext den zu dekodierenden Geheimtext 
	 * @return String: der dekodierte Text
	 */
	public String dekodiere(String geheimtext);
	/**
	 * Gib das vorher zu setzende Loesungwort wieder
	 * @return das Loesungswort als String
	 */
	public String gibLosung();
	/**
	 * Setzt ein Objekt ein Loesungswort
	 * @param schluessel der zu setztende Schluessel
	 * @throws IllegalArgumentException wirft IAE, falls ein ungeeigneter Schluessel gesetzt wird
	 */
	public void setzeLosung(String schluessel)throws IllegalArgumentException;
	
}
