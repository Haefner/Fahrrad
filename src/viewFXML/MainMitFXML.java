package viewFXML;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class MainMitFXML extends Application {

	

	public static void main(String[] args) {
		launch(args);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void start(Stage stage) {
		stage.setTitle("TableView (Fahrrad)");
		try {
			// Load root layout from fxml file.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainMitFXML.class.getResource("tabelle.fxml"));
			AnchorPane rootLayout = (AnchorPane) loader.load();

			//Fügt dem Fenster die Zene mit der Tabelle hinzuhinzu
			Scene scene = new Scene(rootLayout);
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
