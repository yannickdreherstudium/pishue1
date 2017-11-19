package pis.hue1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
/**
 * @author Yannick Dreher 5155125
 *
 */
public class alteGui extends Application{

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

}
