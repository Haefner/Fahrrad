package appStart;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import viewFXML.MainMitFXML;


public class LoginController {
	

	@FXML
	private TextField benutzer;
	@FXML
	private PasswordField passwort;
	
	public LoginController() {
	}
	
	@FXML
	private void initialize() {
	};
	
	@FXML
	public void handleLoginButtonOnAction(Event e) {
		if ((benutzer.getText().equals("Admin")) & (passwort.getText().equals("Admin"))) {

			Stage primaryStage = (Stage) ((Node) e.getSource()).getScene().getWindow();

			try {
				startTableView();
				primaryStage.close();

			} catch (IOException e1) {
				zeigeFehlermeldungAn(e1);
			}
		}
	}
	
	@FXML
	public void handleCancelButtonOnAction (Event e) {
		exitApp();
	}
	
	
	/**
	 * Startet das Verwaltungsfenster
	 * 
	 * @throws IOException
	 */
	private void startTableView() throws IOException {
		
		// Load root layout from fxml file.
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(MainMitFXML.class.getResource("tabelle.fxml"));
		AnchorPane rootLayout;
		rootLayout = (AnchorPane) loader.load();
		//Fügt dem Fenster die Szene mit der Tabelle hinzu
		Stage stage = new Stage();
		stage.setTitle("TableView (Fahrrad)");
		Scene scene = new Scene(rootLayout);
		stage.setScene(scene);
		stage.show();
		
	}
	
	
	/**
	 * Löst einen Alarm aus, welcher nach einer Bestätigung das Programm beendet
	 * 
	 * @author Felix Berger
	 */
	private void exitApp() {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Programm Verlassen");
		alert.setHeaderText("Sind Sie sicher, dasss sie das Programm verlassen wollen?");

		// showAndWait wartet auf Bestätigung
		Optional<ButtonType> option = alert.showAndWait();

		if (option.get() == ButtonType.OK) {
			Platform.exit();
		}

		return;
	}

	/**
	 * Zeigt einen Alarm mit dem Titel der Exception und der StackTrace als Content
	 * 
	 * @param e {@link Exception}
	 * @author Felix Berger
	 */
	void zeigeFehlermeldungAn(Exception e) {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle(e.getMessage());
		alert.setContentText(e.getStackTrace().toString());
		alert.showAndWait();
	}
}
