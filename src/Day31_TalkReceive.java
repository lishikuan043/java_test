import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * Created by Administrator on 2018/2/26.
 */
public class Day31_TalkReceive {
    public static void main(String[] args) throws IOException{
        boolean flag = true;
        DatagramSocket ds = new DatagramSocket(6000);
        while (flag) {
            byte[] data = new byte[1024];
            DatagramPacket dp = new DatagramPacket(data,data.length);
            ds.receive(dp);
            String output = new String(data,0,dp.getLength());
            System.out.println("New Message from " + dp.getAddress().getHostAddress() + ": " + output);
            if (output.equals("bye!")) {
                flag = false;
                System.out.println("System close!");
            }
        }
        ds.close();
    }
}
