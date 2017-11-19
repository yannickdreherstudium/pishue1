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
	private Codec c1, c2;
	CodecGui(Codec _c1, Codec _c2){
		c1=_c1;
		c2=_c2;
	}
	
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
//				new CodecGui(new Wuerfel(), new Wuerfel());
				c1.setzeLoesung(lwort1.toString());
				c2.setzeLoesung(lwort2.toString());
				geheimtext.setText(c2.kodiere(c1.kodiere(klartext.toString())));
			}else {
				c2.setzeLoesung(lwort1.toString());
				c2.kodiere(klartext.toString());
				geheimtext.setText(c2.gibLoesung());
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
				c1.setzeLoesung(lwort1.toString());
				c1.dekodiere(klartext.toString());
				c1.setzeLoesung(lwort2.toString());
				c1.dekodiere(c1.gibLoesung());
				geheimtext.setText(c1.gibLoesung());
			}else {
				c2.setzeLoesung(lwort1.toString());
				c2.dekodiere(klartext.toString());
				geheimtext.setText(c2.gibLoesung());
			}
		} catch (IllegalArgumentException e) {
			errorlabel.setOpacity(1.0);
			errorlabel.setText("Das ist keine gute Eingabe");
		}
	}

}
