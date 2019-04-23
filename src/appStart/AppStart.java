package appStart;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AppStart extends Application {

	public static void main(String[] args) {
		launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent vab = FXMLLoader.load(getClass().getResource("login.fxml"));
		primaryStage.setTitle("Fahradverwaltung Login");
		primaryStage.setScene(new Scene(vab));
		primaryStage.show();
	}

}
