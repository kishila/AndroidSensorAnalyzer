package chartComponent;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;

public class PlotData {

	public static LinkedList<Integer> value = new LinkedList<Integer>();
	private static Random rnd = new Random();

	static {
		resetData();
	}

	static public void resetData(){
		value.clear();
        for(int i=0;i<50;i++){
        	value.add(rnd.nextInt(50));
        }
	}

	static public void addData(){
		value.poll();
        value.add(rnd.nextInt(50));
	}

}
