package pis.hue1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
/**
 * Diese Klasse enthällt die main-Methode und startet die JavaFX Benutzeroberflaeche
 * 
 * Die Klasse erbt von Application
 * 
 * @author Yannick Dreher 5155125
 * @version final 1.0 Abgabe
 */
public final class Gui extends Application{

	/**
	 * Die main-Methode startet die Benutzeroberflaeche
	 * @param args  uebergabe
	 */
	public static void main(String[] args) {
		launch(args);
	}
	/**
	 * Die start Methode inizialisiert die JavaFX Benutzeroberflaeche
	 */
	@Override
	public void start(Stage stage) throws Exception {
		Pane root = (Pane) FXMLLoader.load(getClass().getResource("gui.fxml"));
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("PiS Hue1");
		stage.show();
	}

}

