module com.example.comp214_groupassignment4 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.bootstrapfx.core;
    requires java.sql;
    requires java.desktop;
    requires java.sql.rowset;

    opens com.example.comp214_groupassignment4 to javafx.fxml;
    exports com.example.comp214_groupassignment4;
}