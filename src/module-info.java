module FahrradVerwaltung {
	opens application;
	exports Model;
	opens viewFXML;
	opens appStart;

	requires java.sql;
	requires javafx.base;
	requires javafx.controls;
	requires javafx.graphics;
	requires javafx.fxml;
	requires java.desktop;
}