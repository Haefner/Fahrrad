package application;
 
 
import Model.Fahrrad;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
 
public class TableViewDemo extends Application {
 
  @Override
  public void start(Stage stage) {
 
      TableView<Fahrrad> table = new TableView<Fahrrad>();
 
      TableColumn<Fahrrad, String> userNameCol 
              = new TableColumn<Fahrrad, String>("Bezeichung");
 
      TableColumn<Fahrrad, String> emailCol//
              = new TableColumn<Fahrrad, String>("Artikelnummer");
 
      TableColumn<Fahrrad, String> fullNameCol//
              = new TableColumn<Fahrrad, String>("Farbe");
      
      TableColumn<Fahrrad, Integer> lastNameCol //
      = new TableColumn<Fahrrad, Integer>("Zoll");
 
 
   
 
      // Add sub columns to the FullName
     // fullNameCol.getColumns().addAll(firstNameCol, lastNameCol);
 
      // Active Column
      TableColumn<Fahrrad, Boolean> activeCol//
              = new TableColumn<Fahrrad, Boolean>("Active");
 
      table.getColumns().addAll(userNameCol, emailCol, fullNameCol, activeCol);
 
      StackPane root = new StackPane();
      root.setPadding(new Insets(5));
      root.getChildren().add(table);
 
      stage.setTitle("TableView (o7planning.org)");
 
      Scene scene = new Scene(root, 450, 300);
      stage.setScene(scene);
      stage.show();
  }
 
  public static void main(String[] args) {
      launch(args);
  }
}
