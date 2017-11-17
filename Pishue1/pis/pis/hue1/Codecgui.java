package pis.hue1;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

/**
 * @author Yannick Dreher 5155125
 *
 */
public class Codecgui {
	@FXML
	TextArea klartext;
	@FXML
	TextArea geheimtext;
	@FXML
	Button verschluesseln;
	@FXML
	Button entschluesseln;
	@FXML
	private void startverschluesseln() {
		klartext.clear();
	}
	@FXML
	private void startentschluesseln() {
		geheimtext.clear();
	}
}
