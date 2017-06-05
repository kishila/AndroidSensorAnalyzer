package com.example.a16g459.bluetoothsample;

import java.util.TimerTask;

public class MessageThread extends TimerTask  {

    private BluetoothTask bluetoothTask;

    MessageThread(BluetoothTask task) {
        this.bluetoothTask = task;
    }

    public void run() {
        bluetoothTask.doSend(encodeMessage(SensorValuePool.getAccelerMeterValue()));
    }

    private String encodeMessage(String[] str){
        return str[0] + ":" + str[1] + ":" + str[2];
    }
}
