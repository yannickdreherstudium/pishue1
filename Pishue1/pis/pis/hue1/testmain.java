package pis.hue1;

public class testmain {

	public static void main(String[] args) {
//		test("Notebook","hallodashieristeinlangerbeispieltextumdasverfahrenzuzeigen");
//		System.out.println(caeser("abcxyz ABCXYZ 09!.", "T"));
		System.out.println(caeser2(caeser("abcxyz ABCXYZ 09!.", "T"), "T"));
//		System.out.print('A'+0);
	}
	public static void test(String schluessel, String klartext) {
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
		for(int j = 0 ; j<(klartext.length()/schluessel.length()+2) ; j++) {
			for(int i=0; i<schluessel.length();i++) {
				System.out.print(matrixsort[j][i]+" ");
			}
			System.out.print("\n");
		}
		
		
		String ausgabe = "";
		for(int i = 0 ; i<schluessel.length() ; i++) {
			for(int j = 1 ; j< klartext.length()/schluessel.length()+2 ; j++) {
				
				ausgabe = ausgabe +matrixsort[j][i];
			}
		}
		System.out.println(ausgabe);
	}

	public static String caeser(String klartext, String sh) {
		int shift = sh.length();
		String ausgabe="";
		char temp='b';
		for(int i = 0 ; i<klartext.length() ; i++) {
			if((klartext.charAt(i)>=97)&&(klartext.charAt(i)<=122)) {
				temp=(char) (klartext.charAt(i)+shift);
				if(temp>122) {
					temp-=26;
				}
			}else {
				if(klartext.charAt(i)>=66&&klartext.charAt(i)<=90){
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
	public static String caeser2(String geheimtext, String sh) {
		int shift = sh.length();
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

}
   
