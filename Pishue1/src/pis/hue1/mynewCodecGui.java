package pis.hue1;

public class mynewCodecGui {
	Codec c1, c2;
	
	public mynewCodecGui(Codec _c1, Codec _c2) {
		this.c1 = _c1;
		this.c2 = _c2;
	}
	public mynewCodecGui(Codec _c1) {
		this.c1 = _c1;
	}
	
	public String kodiere_w(String klartext) {
		return c2.kodiere(c1.kodiere(klartext));
	}
	public String kodiere_c(String klartext) {
		return c1.kodiere(klartext);
	}
	
	public static String buttonkodiere(String klartext, String lw1, String lw2) {
		mynewCodecGui a = new mynewCodecGui(new Wuerfel(lw1),new Wuerfel(lw2));
		return a.kodiere_w(klartext);
	}
	public static String buttonkodiere(String klartext, String lw1) {
		mynewCodecGui a = new mynewCodecGui(new Caesar(lw1));
		return a.kodiere_c(klartext);
	}
	
	public String dekodiere_w(String klartext) {
		return c2.dekodiere(c1.dekodiere(klartext));
	}
	public String dekodiere_c(String klartext) {
		return c1.dekodiere(klartext);
	}
	
	public static String buttondekodiere(String klartext, String lw1, String lw2) {
		mynewCodecGui a = new mynewCodecGui(new Wuerfel(lw1),new Wuerfel(lw2));
		return a.dekodiere_w(klartext);
	}
	public static String buttondekodiere(String klartext, String lw1) {
		mynewCodecGui a = new mynewCodecGui(new Caesar(lw1));
		return a.dekodiere_c(klartext);
	}
}
