package application;

import Model.Fahrrad;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void start(Stage stage) {

		TableView<Fahrrad> table = new TableView<Fahrrad>();

		TableColumn<Fahrrad, String> typ = new TableColumn<Fahrrad, String>("Typ");

		TableColumn<Fahrrad, String> farbe = new TableColumn<Fahrrad, String>("Farbe");

		TableColumn<Fahrrad, Integer> zoll = new TableColumn<Fahrrad, Integer>("Zoll");

		TableColumn<Fahrrad, String> bezeichnung = new TableColumn<Fahrrad, String>("Bezeichung");

		TableColumn<Fahrrad, String> name = new TableColumn<Fahrrad, String>("Name");

		TableColumn<Fahrrad, String> artikelnummer = new TableColumn<Fahrrad, String>("Artikelnummer");

		bezeichnung.getColumns().addAll(name, artikelnummer);

		table.getColumns().addAll(bezeichnung, typ, farbe, zoll);

		// Definiere, welcher Wert des Objektes Fahrrad zu welcher Tabellenzeile gehört
		name.setCellValueFactory(new PropertyValueFactory<>("name"));
		artikelnummer.setCellValueFactory(new PropertyValueFactory<>("artikelnummer"));
		typ.setCellValueFactory(new PropertyValueFactory<>("typ"));
		farbe.setCellValueFactory(new PropertyValueFactory<>("farbe"));
		zoll.setCellValueFactory(new PropertyValueFactory<>("zoll"));

		// Füge einträge hinzu
		table.setItems(getRadList());

		StackPane root = new StackPane();
		root.setPadding(new Insets(3));
		root.getChildren().add(table);

		stage.setTitle("TableView (Fahrrad)");

		Scene scene = new Scene(root, 450, 300);
		stage.setScene(scene);
		stage.show();
	}

	private ObservableList<Fahrrad> getRadList() {

		Fahrrad rad1 = new Fahrrad("Green Bike", "1234", "Cityrad", "Grün", 28);
		Fahrrad rad2 = new Fahrrad("Blitz", "1245", "Rennrad", "Gelb", 28);
		Fahrrad rad3 = new Fahrrad("Pink Bike", "12456", "Mountainbike", "Pink", 28);

		ObservableList<Fahrrad> list = FXCollections.observableArrayList(rad1, rad2, rad3);
		return list;
	}
}
