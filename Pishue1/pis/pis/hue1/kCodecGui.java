package pis.hue1;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
/**
 * @author Yannick Dreher 5155125
 *
 */
public class kCodecGui extends Application{

	public static void main(String[] args) {
		launch("test");
	}

	@Override
	public void start(Stage stage) throws Exception {
		Pane root = (Pane) FXMLLoader.load(getClass().getResource("gui.fxml"));
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("PiS Hue1");
		stage.show();
	}
	

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
		errorlabel.setOpacity(0.0);
		try {
			if(doppelwuerfel.isSelected()) {
				c1.setzeLoesung(lwort1.getText());
				c2.setzeLoesung(lwort2.getText());
				geheimtext.setText(c2.kodiere(c1.kodiere(klartext.getText())));
			}else {
				if(lwort1!=null) {
					c3.setzeLoesung(lwort1.getText());			
				geheimtext.setText(c3.kodiere(klartext.getText()));
				}
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