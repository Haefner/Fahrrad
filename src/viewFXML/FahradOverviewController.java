package viewFXML;

import java.net.URL;
import java.util.ResourceBundle;

import Model.Fahrrad;
import javafx.collections.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;

public class FahradOverviewController{
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

	@FXML
	private void initialize() {
		ordneTabellenzeilenZuVariablenDesObjektes();
		fahrradTablle.setItems(getRadList());
		aenderungDerOberflaeche();

	}

	/**
	 * Definiere, welcher Wert des Objektes Fahrrad zu welcher Tabellenzeile gehört
	 */
	private void ordneTabellenzeilenZuVariablenDesObjektes() {
		name.setCellValueFactory(new PropertyValueFactory<Fahrrad, String>("name"));
		artikelnummer.setCellValueFactory(new PropertyValueFactory<>("artikelnummer"));
		typ.setCellValueFactory(new PropertyValueFactory<>("typ"));
		farbe.setCellValueFactory(new PropertyValueFactory<>("farbe"));
		zoll.setCellValueFactory(new PropertyValueFactory<>("zoll"));
	}
	
	/**
	 * Ermöglicht, dass der Name des Fahrrades auf der Oberfläche geändert werden kann
	 */
	private void aenderungDerOberflaeche() {
		//Allgemein das ändern in der Tabelle ermöglichen
		fahrradTablle.setEditable(true);
		//Definiert, das die Tabellenzelle änderbar ist
		name.setCellFactory(TextFieldTableCell.<Fahrrad>forTableColumn());
		//Sorgt dafür, dass die Änderungen an der Oberfläche registriert werden
		name.setOnEditCommit((CellEditEvent<Fahrrad, String> event) -> {
			String newName = event.getNewValue();
			TablePosition<Fahrrad, String> pos = event.getTablePosition();
			int row = pos.getRow();
			Fahrrad r = event.getTableView().getItems().get(row);
			r.setName(newName);
		});
		
		artikelnummer.setCellFactory(TextFieldTableCell.<Fahrrad>forTableColumn());
	}
	
	@FXML
	public void aenderArtikelnummer(CellEditEvent<Fahrrad, String> event)
	{
		String newName = event.getNewValue();
		TablePosition<Fahrrad, String> pos = event.getTablePosition();
		int row = pos.getRow();
		Fahrrad r = event.getTableView().getItems().get(row);
		r.setArtikelnummer(newName);
	}

	private ObservableList<Fahrrad> getRadList() {
		Fahrrad rad1 = new Fahrrad("Green Bike", "1234", "Cityrad", "Grün", 28);
		Fahrrad rad2 = new Fahrrad("Blitz", "1245", "Rennrad", "Gelb", 28);
		Fahrrad rad3 = new Fahrrad("Pink Bike", "12456", "Mountainbike", "Pink", 28);

		ObservableList<Fahrrad> list = FXCollections.observableArrayList(rad1, rad2, rad3);
		return list;
	}

}
