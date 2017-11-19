package pis.hue1;

/**
 * @author Yannick Dreher 5155125
 *
 */
public class Caesar implements Codec {
	String loesung;

	@Override
	public String kodiere(String klartext) {
		int shift = this.loesung.length();
		String ausgabe="";
		char temp='b';
		for(int i = 0 ; i<klartext.length() ; i++) {
			if((klartext.charAt(i)>=97)&&(klartext.charAt(i)<=122)) {
				temp=(char) (klartext.charAt(i)+shift);
				if(temp>122) {
					temp-=26;
				}
			}else {
				if(klartext.charAt(i)>=65&&klartext.charAt(i)<=90){
					temp=(char) (klartext.charAt(i)+shift);
					if(temp>90) {
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
				if(geheimtext.charAt(i)>=66&&geheimtext.charAt(i)<=90){
					temp=(char) (geheimtext.charAt(i)-shift);
					if(temp<66) {
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

	@Override
	public String gibLosung() {
		return this.loesung;
	}

	@Override
	public void setzeLoesung(String schluessel) throws IllegalArgumentException {
		this.loesung=schluessel;
	}

}
