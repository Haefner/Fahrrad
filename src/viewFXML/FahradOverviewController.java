package viewFXML;

import java.net.URL;
import java.util.ResourceBundle;

import Model.Fahrrad;
import javafx.collections.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class FahradOverviewController implements Initializable {
	@FXML
    private TableView<Fahrrad> fahrradTablle;
	@FXML
	private TableColumn<Fahrrad, String> typ;
	@FXML
	private TableColumn<Fahrrad, String> farbe;
	@FXML
	private TableColumn<Fahrrad, Integer> zoll;
	@FXML
	private TableColumn<Fahrrad, String> name;
	@FXML
	private TableColumn<Fahrrad, String> artikelnummer;

	// Reference to the main application.
	private MainMitFXML mainApp;

	/**
	 * The constructor. The constructor is called before the initialize() method.
	 */
	public FahradOverviewController() {
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		initialize();
		fahrradTablle.setItems(getRadList());
		
	}

	/**
	 * Initializes the controller class. This method is automatically called after
	 * the fxml file has been loaded.
	 */
	@FXML
	private void initialize() {
		// Definiere, welcher Wert des Objektes Fahrrad zu welcher Tabellenzeile gehört
		// Definiere, welcher Wert des Objektes Fahrrad zu welcher Tabellenzeile gehört
				name.setCellValueFactory(new PropertyValueFactory<Fahrrad, String>("name"));
				artikelnummer.setCellValueFactory(new PropertyValueFactory<>("artikelnummer"));
				typ.setCellValueFactory(new PropertyValueFactory<>("typ"));
				farbe.setCellValueFactory(new PropertyValueFactory<>("farbe"));
				zoll.setCellValueFactory(new PropertyValueFactory<>("zoll"));
	}
	
	 /**
     * Is called by the main application to give a reference back to itself.
     * 
     * @param mainApp
     */
    public void setMainApp(MainMitFXML mainApp) {
        this.mainApp = mainApp;

        // Add observable list data to the table
        
    }
    
    private ObservableList<Fahrrad> getRadList() {
		Fahrrad rad1 = new Fahrrad("Green Bike", "1234", "Cityrad", "Grün", 28);
		Fahrrad rad2 = new Fahrrad("Blitz", "1245", "Rennrad", "Gelb", 28);
		Fahrrad rad3 = new Fahrrad("Pink Bike", "12456", "Mountainbike", "Pink", 28);

		ObservableList<Fahrrad> list = FXCollections.observableArrayList(rad1, rad2, rad3);
		return list;
	}

	
}
