package application;

import java.io.IOException;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import bluetooth.AcceptThread;
import chartComponent.AddValueButton;
import chartComponent.Chart;
import chartComponent.ResetButton;


public class Main extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        stage.setTitle("Line Chart Sample");

        BorderPane pane = new BorderPane();
        pane.setCenter(Chart.lineChart);
        pane.setBottom(ResetButton.button);
        pane.setRight(AddValueButton.button);

        Scene scene  = new Scene(pane,1200,600);

        stage.setScene(scene);
        stage.show();

    	AcceptThread acceptThread = new AcceptThread();
    	acceptThread.start();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
