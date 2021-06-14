open module javafx {

  requires javafx.graphics;
  requires javafx.fxml;
  requires javafx.controls;
  requires java.sql;
  requires javafx.base;
  requires de.jensd.fx.fontawesomefx.fontawesome;
  requires java.desktop;
  requires mongo.java.driver;
  requires org.apache.commons.io;
    requires com.google.gson;


    exports ehu.isad;
}
