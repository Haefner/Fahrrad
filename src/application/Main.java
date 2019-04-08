package application;

import Model.Fahrrad;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) {

		TableView<Fahrrad> table = new TableView<Fahrrad>();

		TableColumn<Fahrrad, String> bezeichnung = new TableColumn<Fahrrad, String>("Bezeichung");
		
		TableColumn<Fahrrad, String> name = new TableColumn<Fahrrad, String>("Name");

		TableColumn<Fahrrad, String> artikelnummer//
				= new TableColumn<Fahrrad, String>("Artikelnummer");
		
		bezeichnung.getColumns().addAll(name,artikelnummer);

		TableColumn<Fahrrad, String> farbe//
				= new TableColumn<Fahrrad, String>("Farbe");

		TableColumn<Fahrrad, Integer> zoll //
				= new TableColumn<Fahrrad, Integer>("Zoll");

		table.getColumns().addAll(bezeichnung, farbe, zoll);

		StackPane root = new StackPane();
		root.setPadding(new Insets(3));
		root.getChildren().add(table);

		stage.setTitle("TableView (Fahrrad)");

		Scene scene = new Scene(root, 450, 300);
		stage.setScene(scene);
		stage.show();
	}
}
