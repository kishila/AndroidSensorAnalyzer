package bluetooth;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;

import javax.microedition.io.StreamConnection;

/**
 * セッション。
 * - 並列にセッションを晴れるかは試していない。
 * - 基本的に Socket と同じ。
 */
public class Session implements Runnable {


        private StreamConnection channel = null;
        private InputStream btIn = null;
        private OutputStream btOut = null;

        public Session(StreamConnection channel) throws IOException {
            this.channel = channel;
            this.btIn = channel.openInputStream();
            this.btOut = channel.openOutputStream();
        }

        /**
         * 英小文字の受信データを英大文字にしてエコーバックする。
         * - 入力が空なら終了。
         */
        public void run() {
            try {
                byte[] buff = new byte[512];
                int n = 0;
                while ((n = btIn.read(buff)) > 0) {
                    String data = new String(buff, 0, n);
                    log("Receive:"+data);
                    btOut.write(data.toUpperCase().getBytes());
                    btOut.flush();
                }
            } catch (Throwable t) {
                t.printStackTrace();
            } finally {
                close();
            }
        }
        public void close() {
            log("Session Close");
            if (btIn    != null) try {btIn.close();} catch (Exception e) {/*ignore*/}
            if (btOut   != null) try {btOut.close();} catch (Exception e) {/*ignore*/}
            if (channel != null) try {channel.close();} catch (Exception e) {/*ignore*/}
        }

        private static void log(String msg) {
            System.out.println("["+(new Date()) + "] " + msg);
        }
}
