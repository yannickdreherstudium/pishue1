package pis.hue1;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

/**
 * @author Yannick Dreher 5155125
 *
 */
public class codecgui {
	@FXML
	TextArea klartext;
	@FXML
	Button verschluesseln;
	@FXML
	protected void buttonPressd() {
		klartext.clear();
	}
}
