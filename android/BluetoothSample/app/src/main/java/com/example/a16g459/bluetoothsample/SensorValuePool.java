package com.example.a16g459.bluetoothsample;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;

public class SensorValuePool implements SensorEventListener {
    private static String[] accelerMeter = new String[3];

    public static String[] getAccelerMeterValue(){
        return accelerMeter;
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        int i;
        for(i=0;i<3;i++) {
            accelerMeter[i] = String.valueOf(event.values[i]);
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
