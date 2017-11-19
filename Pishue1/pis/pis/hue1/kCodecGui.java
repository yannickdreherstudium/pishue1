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
public class kCodecGui {

	private Codec c1, c2;
	public kCodecGui(){
//		c1=_c1;
//		c2=_c2;
		System.out.print("test");
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
	}
	@FXML
	private void startentschluesseln() {
		
	}
	
}
