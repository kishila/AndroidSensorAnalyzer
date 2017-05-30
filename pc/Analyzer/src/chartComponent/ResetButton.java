package chartComponent;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;

public class ResetButton extends Button {

	public static Button button;

	static {
		button = new Button("Reset");
	    button.setOnAction(new EventHandler<ActionEvent>() {
	        @Override
	        public void handle(ActionEvent e) {
	        	PlotData.resetData();
	        	Chart.update();
	        }
	    });
	}
}


