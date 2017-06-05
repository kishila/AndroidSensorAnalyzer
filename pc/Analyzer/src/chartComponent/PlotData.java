package chartComponent;

import java.util.LinkedList;

public class PlotData {

	public LinkedList<Double> value = new LinkedList<Double>();

	PlotData() {
		resetData();
	}

	public void resetData(){
		value.clear();
        for(int i=0;i<50;i++){
        	// value.add(Math.random() * 10);
        	value.add(0.0);
        }
	}

	public void addData(){
		value.poll();
        value.add(Math.random() * 10);
	}
	public void addData(Double data) {
		value.poll();
		value.add(data);
	}
}
