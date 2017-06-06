package bluetooth;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.util.Date;

import javax.microedition.io.StreamConnection;

import chartComponent.Chart;
import chartComponent.SensorData;

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
                    double datas[] = rounding(decode(data));

                    SensorData.dataX.addData(datas[0]);
                    SensorData.dataY.addData(datas[1]);
                    SensorData.dataZ.addData(datas[2]);
                    Chart.update();
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

        /*
         * 「:」区切りでデータを分離
         */
        private String[] decode(String msg){
        	String data1 = msg.substring(0, msg.indexOf(":"));
        	String tmp = msg.substring(msg.indexOf(":")+1);
        	String data2 = tmp.substring(0, tmp.indexOf(":"));
        	String data3 = tmp.substring(tmp.indexOf(":")+1);
        	return new String[] { data1, data2, data3 };
        }

        private double[] rounding(String[] str){
        	Double data1 = Double.parseDouble(str[0]);
        	Double data2 = Double.parseDouble(str[1]);
        	Double data3 = Double.parseDouble(str[2]);

        	BigDecimal bd1 = new BigDecimal(data1);
        	BigDecimal bd2 = new BigDecimal(data2);
        	BigDecimal bd3 = new BigDecimal(data3);

        	// 小数第5位で切り捨て
        	bd1 = bd1.setScale(4, BigDecimal.ROUND_DOWN);
        	bd2 = bd2.setScale(4, BigDecimal.ROUND_DOWN);
        	bd3 = bd3.setScale(4, BigDecimal.ROUND_DOWN);


        	return new double[] {bd1.doubleValue(), bd2.doubleValue(), bd3.doubleValue()};
        }
}
