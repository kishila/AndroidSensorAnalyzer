package com.example.a16g459.bluetoothsample;

import java.util.TimerTask;

/**
 * Created by KISHILA on 2017/06/05.
 */

public class MessageThread extends TimerTask {

    BluetoothTask bluetoothTask;

    MessageThread(BluetoothTask task) {
        this.bluetoothTask = task;
    }

    public void run() {
        bluetoothTask.doSend("test");
    }
}
