package pis.hue1;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
// eigen geschriebene Gui, entkopplung, implementierung als 1 dimensionales array
/**
 * Die Klasse regelt die Felder und Ereinisse aus der Benutzeroberflaeche
 * 
 * @author Yannick Dreher 5155125
 * @version final 1.0 Abgabe
 */
public final class CodecController {
	/** Die Textarea, zum eingeben des Klartextes */
	@FXML
	TextArea klartext;
	/** Die Textarea, zum eingeben des Geheimtextes */
	@FXML
	TextArea geheimtext;
	/** Das Textfeld, fuer das erste Loesungswort */
	@FXML
	TextField lwort1;
	/** Das Textfeld, fuer das zweite Loesungswort */
	@FXML
	TextField lwort2;
	/** RadioButton, Auswahl der Caesar-Verschluesselung */
	@FXML
	RadioButton caesar;
	/** RadioButton, Auswahl der Doppelwuerfel-Verschluesselung, ist Standartmaessig ausgewaehlt */
	@FXML
	RadioButton doppelwuerfel;
	/** Der Buttom, der das Verschluesseln startet, ruft die Methode startverschluesseln auf */
	@FXML
	Button verschluesseln;
	/** Der Button, der das Entschluesseln startet, rugt die Methode startentschluesseln auf */
	@FXML
	Button entschluesseln;
	
	/**
	 * Startet das Verschluesseln
	 * 
	 * Allerdings nur dann, wenn der eingegebene Klartext nicht leer ist.
	 * Ist fuer die Auswahl der Verschluesselung Caeser und Doppelwuerfel geschrieben 
	 * Wirft und faengt eine IllegalArgumentException, falls ein eingegebenes Loesungswort nicht in der richtigen
	 * Formation ist, oder der Klartext leer ist.
	 */
	@FXML
	private void startverschluesseln() {
		try {
			if(klartext.getText().isEmpty() == false && doppelwuerfel.isSelected()) {
				CodecGui prozess = new CodecGui(lwort1.getText(), lwort2.getText());
				geheimtext.setText(prozess.kodiere(klartext.getText()));				
			}else {
				if(klartext.getText().isEmpty() == false && caesar.isSelected()) {
					CodecGui prozess = new CodecGui(lwort1.getText());
					geheimtext.setText(prozess.kodiere(klartext.getText()));
				}else{
					throw new IllegalArgumentException("Da ist eine leere Eingabe");
				}
			}	
		} catch (IllegalArgumentException e) {
			error(e.getMessage());
		}
	}
	/**
	 * Startet das Entschluesseln
	 * 
	 * Allerdings nur dann, wenn der eingegebene Geheimtext nicht leer ist.
	 * Ist fuer die Auswahl der Verschluesselung Caeser und Doppelwuerfel geschrieben 
	 * Wirft und faengt eine IllegalArgumentException, falls ein eingeebenes Loesungswort nicht ind der richtigen Formation ist
	 * oder der Kalrtext leer ist. Ruft dann die Methode error auf.
	 */
	@FXML
	private void startentschluesseln() {
		try {	
			if(doppelwuerfel.isSelected() && geheimtext.getText().isEmpty() == false) {						
					CodecGui prozess = new CodecGui(lwort1.getText(),lwort2.getText());
					klartext.setText(prozess.dekodiere(geheimtext.getText()));
			}else {
				if(caesar.isSelected()) {
					CodecGui prozess = new CodecGui(lwort1.getText());
					klartext.setText(prozess.dekodiere(geheimtext.getText()));				
				}else {
					throw new IllegalArgumentException("Da ist eine leere Eingabe");
				}
			}
		} catch (IllegalArgumentException e) {
			error(e.getMessage());
		}
	}
	
	/**
	 * Wird nach einer gefangenen Exception aufgerufen 
	 * 
	 * und gibt diese als Alertbox dem Benutzer
	 * @param error die Massage von der Exception
	 */
	private void error(String error) {
		Alert alerterror = new Alert(Alert.AlertType.INFORMATION);
        alerterror.setTitle("Ein Fehler ist aufgetreten");
        alerterror.setHeaderText(error);
        alerterror.showAndWait();
	
	}
	
	/**
	 * Wird aufgerufen, sobald der Benutzer die Caeser-Verschluesselung auswaehlt
	 * 
	 * Loescht das zweite Loesungswort, und deaktiviert die Eingabe davon
	 */
	@FXML
	private void switchcaeser() {
		lwort2.setEditable(false);
		lwort2.setDisable(true);
		lwort2.clear();
	}
	/**
	 * Wird aufgerufen, sobald der Benutzer die Wuerfel-Verschluesselung auswaehlt
	 * 
	 * aktiviert die Eingabe von dem zweiten Loesungswort wieder
	 */
	@FXML
	private void switchdoppel() {
		lwort2.setEditable(true);
		lwort2.setDisable(false);
	}

}
