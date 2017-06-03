package bluetooth;

import java.io.IOException;
import java.util.Date;

import javax.bluetooth.LocalDevice;
import javax.bluetooth.ServiceRecord;
import javax.microedition.io.Connector;
import javax.microedition.io.StreamConnection;
import javax.microedition.io.StreamConnectionNotifier;

public class BluetoothServer {
    /**
     * UUIDは独自プロトコルのサービスの場合は固有に生成する。
     * - 各種ツールで生成する。（ほぼ乱数）
     * - 注：このまま使わないように。
     */
    static final String serverUUID = "11111111111111111111111111111123";

    private StreamConnectionNotifier server = null;

    public BluetoothServer() throws IOException {
        // RFCOMMベースのサーバの開始。
        // - btspp:は PRCOMM 用なのでベースプロトコルによって変わる。
        server = (StreamConnectionNotifier) Connector.open(
                "btspp://localhost:" + serverUUID,
                Connector.READ_WRITE, true
        );
        // ローカルデバイスにサービスを登録。必須ではない。
        ServiceRecord record = LocalDevice.getLocalDevice().getRecord(server);
        LocalDevice.getLocalDevice().updateRecord(record);
    }

    /**
     * クライアントからの接続待ち。
     * @return 接続されたたセッションを返す。
     */
    public Session accept() throws IOException {
        log("Accept");
        StreamConnection channel = server.acceptAndOpen();
        log("Connect");
        return new Session(channel);
    }
    public void dispose() {
        log("Dispose");
        if (server  != null) try {server.close();} catch (Exception e) {/*ignore*/}
    }

    private static void log(String msg) {
        System.out.println("["+(new Date()) + "] " + msg);
    }
}
