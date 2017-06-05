package chartComponent;

import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

public class Chart {

	final static NumberAxis xAxis = new NumberAxis();
    final static NumberAxis yAxis = new NumberAxis();

    final public static LineChart<Number,Number> lineChart = new LineChart<Number,Number>(xAxis,yAxis);
    final static XYChart.Series xSeries = new XYChart.Series();
    final static XYChart.Series ySeries = new XYChart.Series();
    final static XYChart.Series zSeries = new XYChart.Series();

	static {
        xAxis.setLabel("x label");
        lineChart.setTitle("Title");
        lineChart.setAnimated(false);
        lineChart.setCreateSymbols(false);
        lineChart.getStylesheets().add("css/chart.css");
        xSeries.setName("X Magnetic");
        ySeries.setName("y Magnetic");
        zSeries.setName("z Magnetic");

        update();
        lineChart.getData().add(xSeries);
        lineChart.getData().add(ySeries);
        lineChart.getData().add(zSeries);
	}

	public static void update(){
		xSeries.getData().clear();
		ySeries.getData().clear();
		zSeries.getData().clear();
        for(int i=0;i<50;i++){
        	xSeries.getData().add(new XYChart.Data(i, SensorData.dataX.value.get(i)));
        	ySeries.getData().add(new XYChart.Data(i, SensorData.dataY.value.get(i)));
        	zSeries.getData().add(new XYChart.Data(i, SensorData.dataZ.value.get(i)));
        }
	}
}
