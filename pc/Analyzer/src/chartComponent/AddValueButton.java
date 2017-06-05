package chartComponent;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class AddValueButton {

	public static Button button;

	static {
		button = new Button("Add Value");
	    button.setOnAction(new EventHandler<ActionEvent>() {
	        @Override
	        public void handle(ActionEvent e) {
	        	SensorData.dataX.addData(0.1);
	        	SensorData.dataY.addData(0.1);
	        	SensorData.dataZ.addData(0.1);
	        	Chart.update();
	        }
	    });
	}
}
