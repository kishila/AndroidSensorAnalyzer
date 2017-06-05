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
	        	SensorData.data1.addData();
	        	SensorData.data2.addData();
	        	SensorData.data3.addData();
	        	Chart.update();
	        }
	    });
	}
}
