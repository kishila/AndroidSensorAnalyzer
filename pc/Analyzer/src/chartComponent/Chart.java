package chartComponent;

import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

public class Chart {

	final static NumberAxis xAxis = new NumberAxis();
    final static NumberAxis yAxis = new NumberAxis();

    final public static LineChart<Number,Number> lineChart = new LineChart<Number,Number>(xAxis,yAxis);
    final static XYChart.Series series = new XYChart.Series();

	static {
        xAxis.setLabel("x label");
        lineChart.setTitle("Title");
        lineChart.setAnimated(false);
        lineChart.setCreateSymbols(false);
        lineChart.getStylesheets().add("css/chart.css");
        series.setName("series title");

        update();
        lineChart.getData().add(series);
	}

	public static void update(){
		series.getData().clear();
        for(int i=0;i<50;i++){
        	series.getData().add(new XYChart.Data(i, PlotData.value.get(i)));
        }
	}
}
