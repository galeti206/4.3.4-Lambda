module es.ieslosmontecillos.lambda {
    requires javafx.controls;
    requires javafx.fxml;


    opens es.ieslosmontecillos.lambda to javafx.fxml;
    exports es.ieslosmontecillos.lambda;
}