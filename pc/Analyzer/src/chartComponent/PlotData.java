package chartComponent;

import java.util.LinkedList;
import java.util.Random;

public class PlotData {

	public LinkedList<Integer> value = new LinkedList<Integer>();
	private Random rnd = new Random();

	PlotData() {
		resetData();
	}

	public void resetData(){
		value.clear();
        for(int i=0;i<50;i++){
        	value.add(rnd.nextInt(50));
        }
	}

	public void addData(){
		value.poll();
        value.add(rnd.nextInt(50));
	}

}
