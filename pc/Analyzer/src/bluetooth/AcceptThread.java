package bluetooth;

import java.io.IOException;



public class AcceptThread extends Thread {
	@Override
	public void run() {
		try {
			BluetoothServer server = new BluetoothServer();
		    while (true) {
		        Session session = server.accept();
		        Thread accept = new Thread(session);
		        accept.start();
		    }
		    //server.dispose();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
