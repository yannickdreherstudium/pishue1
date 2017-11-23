package pis.hue1;

import java.util.regex.Pattern;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * @author Yannick Dreher 5155125
 *
 */
public final class CodecController {
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
	Button verschluesseln;
	@FXML
	Button entschluesseln;
	
	
	@FXML
	private void startverschluesseln() {
		try {
			if(klartext.getText().isEmpty() == false && doppelwuerfel.isSelected()) {
				teste(lwort1.getText());
				teste(lwort2.getText());						
				CodecGui prozess = new CodecGui(new Wuerfel(lwort1.getText()), new Wuerfel(lwort2.getText()));
				geheimtext.setText(prozess.kodiere(klartext.getText()));				
			}else {
				if(klartext.getText().isEmpty() == false && caesar.isSelected()) {
					teste(lwort1.getText());
					CodecGui prozess = new CodecGui(new Caesar(lwort1.getText()), null);
					geheimtext.setText(prozess.kodiere(klartext.getText()));
				}else{
					throw new IllegalArgumentException("Da ist eine leere Eingabe");
				}
			}	
		} catch (IllegalArgumentException e) {
			error(e.getMessage());
		}
	}
	@FXML
	private void startentschluesseln() {
		try {	
			if(doppelwuerfel.isSelected() && geheimtext.getText().isEmpty() == false) {
					teste(lwort1.getText());
					teste(lwort2.getText());						
					CodecGui prozess = new CodecGui(new Wuerfel(lwort1.getText()), new Wuerfel(lwort2.getText()));
					klartext.setText(prozess.dekodiere(geheimtext.getText()));
			}else {
				if(caesar.isSelected()) {
					CodecGui prozess = new CodecGui(new Caesar(lwort1.getText()), null);
					klartext.setText(prozess.dekodiere(geheimtext.getText()));				
				}else {
					throw new IllegalArgumentException("Da ist eine leere Eingabe");
				}
			}
		} catch (IllegalArgumentException e) {
			error(e.getMessage());
		}
	}
	

	private void error(String error) {
		Alert alerterror = new Alert(Alert.AlertType.INFORMATION);
        alerterror.setTitle("Ein Fehler ist aufgetreten");
        alerterror.setHeaderText(error);
        alerterror.showAndWait();
	
	}
	
	private void teste(String loesung) {
		if(loesung == null || loesung.equals("") || loesung.isEmpty()) {
			throw new IllegalArgumentException("Das ist keine gutes Schluesselwort");
		}
		if(loesung.length()<3) {
			throw new IllegalArgumentException("Das Schluesselwort ist zu kurz");
		}
		char[] _loesung = loesung.toLowerCase().toCharArray();
		for(int i= 0 ; i<loesung.length() ; i++) {
			if(Pattern.matches("\\p{Lower}", _loesung[i]+"") == false) {
				throw new IllegalArgumentException("Du darfst nur Buchstaben in den Schluesseln verwenden!");
			}
		}
		
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
		lwort2.clear();
	}
	@FXML
	private void switchdoppel() {
		lwort2.setEditable(true);
		lwort2.setDisable(false);
	}

}
