package es.ieslosmontecillos.lambda;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;



public class Lambda extends Application {
    TextField txt1 = new TextField();
    TextField txt2 = new TextField();
    TextField txt3 = new TextField();
    TextField txt4 = new TextField();
    TextField txt5 = new TextField();

    @Override
    public void start(Stage primaryStage){
        primaryStage.setTitle("Lambda");

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(5);

        Scene scene = new Scene(grid, 320, 240);
        primaryStage.setScene(scene);


        /* Campos*/
        Label lb1 = new Label("Annual Interest Rate:");
        txt1.setAlignment(Pos.CENTER_RIGHT);

        Label lb2 = new Label("Number of Years:");
        txt2.setAlignment(Pos.CENTER_RIGHT);

        Label lb3 = new Label("Loan Amount:");
        txt3.setAlignment(Pos.CENTER_RIGHT);

        Label lb4 = new Label("Monthly Payment:");
        txt4.setAlignment(Pos.CENTER_RIGHT);
        txt4.setEditable(false);

        Label lb5 = new Label("Total Payment:");
        txt5.setAlignment(Pos.CENTER_RIGHT);
        txt5.setEditable(false);

        Button bt1 = new Button("Calculate");
        HBox btnBox = new HBox(bt1);
        btnBox.setAlignment(Pos.BASELINE_RIGHT);

        // Expresión lambda
        bt1.setOnAction(e -> check_payment());


        grid.add(lb1, 0, 0);
        grid.add(txt1, 1, 0);
        grid.add(lb2, 0, 1);
        grid.add(txt2, 1, 1);
        grid.add(lb3, 0, 2);
        grid.add(txt3, 1, 2);
        grid.add(lb4, 0, 3);
        grid.add(txt4, 1, 3);
        grid.add(lb5, 0, 4);
        grid.add(txt5, 1, 4);
        grid.add(btnBox, 1, 5);

        primaryStage.show();
    }

    public void check_payment(){
        try{
            double i = Double.parseDouble(txt1.getText());
            double n = Double.parseDouble(txt2.getText());
            double h = Double.parseDouble(txt3.getText());
            double r = i / (100 * 12);

            double m = (h * r) / (1 - Math.pow((1 + r), (-12 * n)));

            txt4.setText("$" + String.format("%.2f", m));

            double total = (m * 12) * n;

            txt5.setText("$" + String.format("%.2f", total));
        }catch (Exception e){
            txt4.setText("Error");
            txt5.setText("Error");
        }

    }



    public static void main(String[] args) {
        launch();
    }
}