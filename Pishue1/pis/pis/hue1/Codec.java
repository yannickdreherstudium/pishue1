/**
 * 
 */
package pis.hue1;

/**
 * @author yanni
 *
 */
interface Codec {
	public String kodiere(String klartext);
	public String dekodiere(String geheimtext);
	public String gibLoesung();
	public void setzeLoesung(String schluessel)throws IllegalArgumentException;
	
}
