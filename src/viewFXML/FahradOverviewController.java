package viewFXML;

import java.net.URL;
import java.util.ResourceBundle;

import Model.Fahrrad;
import Model.Typ;
import javafx.beans.binding.Bindings;
import javafx.beans.value.ObservableValue;
import javafx.collections.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;
import javafx.util.Callback;

public class FahradOverviewController {
	@FXML
	private TableView<Fahrrad> fahrradTablle;
	@FXML
	private TableColumn<Fahrrad, Typ> typ;
	@FXML
	private TableColumn<Fahrrad, String> farbe;
	@FXML
	private TableColumn<Fahrrad, Integer> zoll;
	@FXML
	private TableColumn<Fahrrad, String> name;
	@FXML
	private TableColumn<Fahrrad, String> artikelnummer;

	// Reiter hinzufuegen
	@FXML
	private TextField nameNeu;
	@FXML
	private TextField artikelnummerNeu;
	@FXML
	private ComboBox<Typ> typNeu;
	@FXML
	private TextField farbeNeu;
	@FXML
	private TextField zollNeu;
	
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
		contextMenuDelete();
		initalizeComboBoxTypNeu();

	}


	/**
	 * Definiere, welcher Wert des Objektes Fahrrad zu welcher Tabellenzeile geh�rt
	 */
	private void ordneTabellenzeilenZuVariablenDesObjektes() {
		name.setCellValueFactory(new PropertyValueFactory<Fahrrad, String>("name"));
		artikelnummer.setCellValueFactory(new PropertyValueFactory<>("artikelnummer"));
		typ.setCellValueFactory(new PropertyValueFactory<>("typ"));
		farbe.setCellValueFactory(new PropertyValueFactory<>("farbe"));
		zoll.setCellValueFactory(new PropertyValueFactory<>("zoll"));
	}

	/**
	 * Erm�glicht, dass der Name des Fahrrades auf der Oberfl�che ge�ndert werden
	 * kann
	 */
	private void aenderungDerOberflaeche() {
		// Allgemein das �ndern in der Tabelle erm�glichen
		fahrradTablle.setEditable(true);
		// F�gt der Tabellenzeile einen Editor zur Text�nderung hinzu
		name.setCellFactory(TextFieldTableCell.<Fahrrad>forTableColumn());
		// Sorgt daf�r, dass die �nderungen an der Oberfl�che registriert werden
		name.setOnEditCommit((CellEditEvent<Fahrrad, String> event) -> {
			String newName = event.getNewValue();
			int row = event.getTablePosition().getRow();
			Fahrrad r = event.getTableView().getItems().get(row);
			r.setName(newName);
		});

		artikelnummer.setCellFactory(TextFieldTableCell.<Fahrrad>forTableColumn());
	}

	private void contextMenuDelete() {
		fahrradTablle.setRowFactory(new Callback<TableView<Fahrrad>, TableRow<Fahrrad>>() {
			@Override
			public TableRow<Fahrrad> call(TableView<Fahrrad> tableView) {
				final TableRow<Fahrrad> row = new TableRow<>();
				final ContextMenu contextMenu = new ContextMenu();
				final MenuItem removeMenuItem = new MenuItem("L�schen");
				removeMenuItem.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent event) {
						fahrradTablle.getItems().remove(row.getItem());
					}
				});
				contextMenu.getItems().add(removeMenuItem);
				// Set context menu on row, but use a binding to make it only show for non-empty
				// rows:
				row.contextMenuProperty()
						.bind(Bindings.when(row.emptyProperty()).then((ContextMenu) null).otherwise(contextMenu));
				return row;
			}
		});
	}

	@FXML
	public void aenderArtikelnummer(CellEditEvent<Fahrrad, String> event) {
		String newName = event.getNewValue();
		// int row = event.getTablePosition().getRow();
		int row = fahrradTablle.getSelectionModel().getSelectedIndex();
		Fahrrad r = event.getTableView().getItems().get(row);
		r.setArtikelnummer(newName);
	}

	private ObservableList<Fahrrad> getRadList() {
		Fahrrad rad1 = new Fahrrad("Green Bike", "1234", Typ.CITYRAD, "Gr�n", 28);
		Fahrrad rad2 = new Fahrrad("Blitz", "1245", Typ.MOUNTAINBIKE, "Gelb", 28);
		Fahrrad rad3 = new Fahrrad("Pink Bike", "12456", Typ.RENNRAD, "Pink", 28);

		ObservableList<Fahrrad> list = FXCollections.observableArrayList(rad1, rad2, rad3);
		return list;
	}

	@FXML
	public void hinzufuegen() {
		Fahrrad rad1 = new Fahrrad(nameNeu.getText(), artikelnummerNeu.getText(), typNeu.getValue(), farbeNeu.getText(),
				Integer.parseInt(zollNeu.getText()));
		nameNeu.clear();
		artikelnummerNeu.clear();
		zollNeu.clear();
		farbeNeu.clear();
		fahrradTablle.getItems().add(rad1);
	}
	
	private void initalizeComboBoxTypNeu() {
		typNeu.getItems().addAll(Typ.values());
		
	}
	
	@FXML
	public void diagramm(ActionEvent event)
	{
		 final CategoryAxis xAxis = new CategoryAxis();
	        final NumberAxis yAxis = new NumberAxis();
	        //creating the chart
	        
	        xAxis.setLabel("Monat");
	        yAxis.setLabel("Verkaufte R�der");
	        final LineChart<String,Number> lineChart = new LineChart<String,Number>(xAxis,yAxis);
			
	        XYChart.Series series = new XYChart.Series();
	        series.setName("2017");
	        series.getData().add(new XYChart.Data("Januar", 10));
	        series.getData().add(new XYChart.Data("Februar", 8));
	        series.getData().add(new XYChart.Data("M�rz", 15));
	        
	        series.getData().add(new XYChart.Data("April", 20));
	        series.getData().add(new XYChart.Data("Mai", 25));
	        series.getData().add(new XYChart.Data("Juni", 20));
	        series.getData().add(new XYChart.Data("Juli", 18));
	        series.getData().add(new XYChart.Data("August", 14));
	        series.getData().add(new XYChart.Data("September", 9));
	        series.getData().add(new XYChart.Data("Oktober", 8));
	        series.getData().add(new XYChart.Data("November", 5));
	        series.getData().add(new XYChart.Data("Dezember", 20));
	        
	        XYChart.Series series2 = new XYChart.Series();
	        series2.setName("2018");
	        series2.getData().add(new XYChart.Data("Januar", 7));
	        series2.getData().add(new XYChart.Data("Februar", 8));
	        series2.getData().add(new XYChart.Data("M�rz", 12));
	        series2.getData().add(new XYChart.Data("April", 22));
	        series2.getData().add(new XYChart.Data("Mai", 26));
	        series2.getData().add(new XYChart.Data("Juni", 10));
	        series2.getData().add(new XYChart.Data("Juli", 12));
	        series2.getData().add(new XYChart.Data("August", 16));
	        series2.getData().add(new XYChart.Data("September", 9));
	        series2.getData().add(new XYChart.Data("Oktober", 7));
	        series2.getData().add(new XYChart.Data("November", 5));
	        series2.getData().add(new XYChart.Data("Dezember", 25));
	        
    	        
	        Scene diagram  = new Scene(lineChart,800,600);
	        //lineChart.getData().addAll(series,series2);
	        lineChart.getData().add(series);
	        lineChart.getData().add(series2);
	        Stage primaryStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
	        primaryStage.setScene(diagram);
	        primaryStage.show();
	}
	

}
