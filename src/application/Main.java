package application;

import Model.Fahrrad;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {

	private TableView<Fahrrad> fahrradTablle;

	private TableColumn<Fahrrad, String> typ;

	private TableColumn<Fahrrad, String> farbe;

	private TableColumn<Fahrrad, Integer> zoll;

	private TableColumn<Fahrrad, String> name;

	private TableColumn<Fahrrad, String> bezeichnung;

	private TableColumn<Fahrrad, String> artikelnummer;

	public static void main(String[] args) {
		launch(args);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void start(Stage stage) {
		stage.setTitle("TableView (Fahrrad)");

		//Tabelle anlegen
		generriereTabellenUndUeberschriften();
		ordneTabellenzeilenZuVariablenDesObjektes();
		aenderungDerOberflaeche();

		AnchorPane root = new AnchorPane();
		root.setPadding(new Insets(3));
		
		// Fuege Eintraege hinzu
		fahrradTablle.setItems(getRadList());
		root.getChildren().add(fahrradTablle);
		
		//Fügt dem Fenster die Zene mit der Tabelle hinzuhinzu
		Scene scene = new Scene(root, 450, 300);
		stage.setScene(scene);
		stage.show();
	}

	/**
	 * Tabellenzeilen auf der Oberfläche anlegen
	 */
	private void generriereTabellenUndUeberschriften() {
		fahrradTablle = new TableView<Fahrrad>();
		typ = new TableColumn<Fahrrad, String>("Typ");
		farbe = new TableColumn<Fahrrad, String>("Farbe");
		zoll = new TableColumn<Fahrrad, Integer>("Zoll");
		bezeichnung = new TableColumn<Fahrrad, String>("Bezeichung");
		name = new TableColumn<Fahrrad, String>("Name");
		artikelnummer = new TableColumn<Fahrrad, String>("Artikelnummer");
		bezeichnung.getColumns().addAll(name, artikelnummer);
		fahrradTablle.getColumns().addAll(bezeichnung, typ, farbe, zoll);
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
	}

	private ObservableList<Fahrrad> getRadList() {

		Fahrrad rad1 = new Fahrrad("Green Bike", "1234", "Cityrad", "Grün", 28);
		Fahrrad rad2 = new Fahrrad("Blitz", "1245", "Rennrad", "Gelb", 28);
		Fahrrad rad3 = new Fahrrad("Pink Bike", "12456", "Mountainbike", "Pink", 28);

		ObservableList<Fahrrad> list = FXCollections.observableArrayList(rad1, rad2, rad3);
		return list;
	}
}
