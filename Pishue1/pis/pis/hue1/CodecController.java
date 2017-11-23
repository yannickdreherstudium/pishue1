/**
 * 
 */
package pis.hue1;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * @author Yannick Dreher 5155125
 *
 */
public class CodecController {
	@FXML
	TextArea klartext;
	@FXML
	TextArea geheimtext;
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
	Button verschluesseln;
	@FXML
	Button entschluesseln;
	
	@FXML
	private void startverschluesseln() {
		try {
			if(klartext.getText() != null && lwort1.getText() != null) {
				if(doppelwuerfel.isSelected() && lwort2.getText() != null) {
					CodecGui prozess = new CodecGui(new Wuerfel(lwort1.getText()), new Wuerfel(lwort2.getText()));
					geheimtext.setText(prozess.kodiere(klartext.getText()));
				}else {
						CodecGui prozess = new CodecGui(new Caesar(lwort1.getText()), null);
						geheimtext.setText(prozess.kodiere(klartext.getText()));
				}
			}else {
				throw new IllegalArgumentException("Da ist eine leere Eingabe");
			}
			
		} catch (IllegalArgumentException e) {
			errorlabel.setOpacity(1.0);
			errorlabel.setText(e.getMessage());
		}
	}
	@FXML
	private void startentschluesseln() {
		try {
			if(klartext.getText() != null && lwort1.getText() != null ) {	
				if(doppelwuerfel.isSelected() && lwort2.getText() != null) {
					CodecGui prozess = new CodecGui(new Wuerfel(lwort1.getText()), new Wuerfel(lwort2.getText()));
					klartext.setText(prozess.dekodiere(geheimtext.getText()));
				}else {
					CodecGui prozess = new CodecGui(new Caesar(lwort1.getText()), null);
					klartext.setText(prozess.dekodiere(geheimtext.getText()));
				}
			}else {
				throw new IllegalArgumentException("Da ist eine leere Eingabe");
			}
		} catch (IllegalArgumentException e) {
			errorlabel.setOpacity(1.0);
			errorlabel.setText(e.getMessage());
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
	@FXML
	private void clearklartext() {
		klartext.clear();
	}
	@FXML
	private void cleargeheimtext() {
		geheimtext.clear();
	}
	@FXML
	private void switchcaeser() {
		lwort2.setEditable(false);
		lwort2.setDisable(true);
	}
	@FXML
	private void switchdoppel() {
		lwort2.setEditable(true);
		lwort2.setDisable(false);
	}

}
