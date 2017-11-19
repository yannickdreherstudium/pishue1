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
public class altecodecgui {
	Codec c1 = new Wuerfel();
	Codec c2 = new Caesar();
	
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
		klartext.clear();
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
	private void startentschluesseln() {
		errorlabel.setOpacity(0.0);
		geheimtext.clear();
	}
}
