package appStart;

import java.io.IOException;
import java.util.Optional;

import javafx.application.Platform;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
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

public class LoginController  {
	

	@FXML
	private TextField benutzer;
	@FXML
	private PasswordField passwort;
	@FXML
	private Button btnLogin;
	@FXML
	private Button btnCancel;
	
	public LoginController() {
	}
	
	@FXML
	private void initialize() {
		
	};
	
	@FXML
	public void handleLoginButtonOnAction (Event e) {
		if((benutzer.getText().equals("Admin")) & (passwort.getText().equals("Admin"))) {
			
			Stage primaryStage = (Stage) btnLogin.getScene().getWindow();

				// Load root layout from fxml file.
				FXMLLoader loader = new FXMLLoader();
				loader.setLocation(MainMitFXML.class.getResource("tabelle.fxml"));
				AnchorPane rootLayout;
				try {
					rootLayout = (AnchorPane) loader.load();
					//Fügt dem Fenster die Zene mit der Tabelle hinzuhinzu
					Stage stage = new Stage();
					stage.setTitle("TableView (Fahrrad)");
					Scene scene = new Scene(rootLayout);
					stage.setScene(scene);
					stage.show();
					primaryStage.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				

	//		Platform.exit();
		}
	}
	
	@FXML
	public void handleCancelButtonOnAction (Event e) {
		exitApp();
	}
	
	/**
	 * Löst einen Alarm aus, welcher nacher Bestätigung das Programm beendet
	 * @author Felix Berger
	 */
	private void exitApp() {
		Alert alert = new Alert(AlertType.CONFIRMATION);
	      alert.setTitle("Programm Verlassen");
	      alert.setHeaderText("Sind Sie sicher, dasss sie das Programm verlassen wollen?");
	 
	      // option != null.
	      Optional<ButtonType> option = alert.showAndWait();
	      
	      if(option.get()==ButtonType.OK)
	      {
	    	  Platform.exit();
	      }
	      
	      return;
	 
	}
	

}
