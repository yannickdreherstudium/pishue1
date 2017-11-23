package pis.hue1;

/**
 * @author Yannick Dreher 5155125
 *  
 */
public final class CodecGui {
	private Codec c1;
	private Codec c2;
	
	public CodecGui(Codec _c1, Codec _c2){
		c1=_c1;
		c2=_c2;
	}
	public String kodiere(String klartext) {
		if(c2 == null) {
			return c1.kodiere(klartext);
		}else {
			return c2.kodiere(c1.kodiere(klartext));
		}
	}
	public String dekodiere(String geheimtext) {
		if(c2 == null) {
			return c1.dekodiere(geheimtext);
		}else {
			return c1.dekodiere(c2.dekodiere(geheimtext));
		}
	}
	
}
