package pis.hue1;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;


/**
 * @author Yannick Dreher 5155125
 *  fx:controller="pis.hue1.Codecgui"
 */
public class CodecGui {
//	private Codec c1, c2;
//	CodecGui(Codec _c1, Codec _c2){
//		c1=_c1;
//		c2=_c2;
//	}
	private Codec c1 = new Wuerfel();
	private Codec c2 = new Wuerfel();
	private Codec c3 = new Caesar();
	
	
	@FXML
	TextArea klartext;
	@FXML
	TextArea geheimtext;
	@FXML
	Button verschluesseln;
	@FXML
	Button entschluesseln;
	@FXML
	TextField lwort1;
	@FXML
	TextField lwort2;
	@FXML
	RadioButton caesar;
	@FXML
	RadioButton doppelwuerfel;
	@FXML
	Label errorlabel;
	@FXML
	private void startverschluesseln() {
		errorlabel.setOpacity(0.0);
		try {
			if(doppelwuerfel.isSelected()) {
				c1.setzeLoesung(lwort1.getText());
				c2.setzeLoesung(lwort2.getText());
				geheimtext.setText(c2.kodiere(c1.kodiere(klartext.getText())));
			}else {
				if(lwort1!=null) {
					c3.setzeLoesung(lwort1.toString());
				}else {
					c3.setzeLoesung(lwort2.toString());
				}				
				geheimtext.setText(c3.kodiere(klartext.getText()));
			}
		} catch (IllegalArgumentException e) {
			errorlabel.setOpacity(1.0);
			errorlabel.setText("Das ist keine gute Eingabe");
		}
	}
	@FXML
	private void startentschluesseln() {
		errorlabel.setOpacity(0.0);
		try {
			if(doppelwuerfel.isSelected()) {

			}else {

			}
		} catch (IllegalArgumentException e) {
			errorlabel.setOpacity(1.0);
			errorlabel.setText("Das ist keine gute Eingabe");
		}
	}
	@FXML
	private void swaptext() {
		String swap = klartext.getText();
		klartext.setText(geheimtext.getText());
		geheimtext.setText(swap);
		
	}
	@FXML
	private void swapwort() {
		String swap = lwort1.getText();
		lwort1.setText(lwort2.getText());
		lwort2.setText(swap);
	}

}
