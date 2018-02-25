import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * Created by Administrator on 2018/2/25.
 *
 * 一个标准的UDP发送端。
 */
public class Day31_UDPsend {
    public static void main(String[] args) throws IOException{
        byte[] data = "UDP数据包一个。".getBytes();
        InetAddress inet = InetAddress.getByName("127.0.0.1");
        DatagramPacket dp = new DatagramPacket(data,data.length,inet,6000);
        DatagramSocket ds = new DatagramSocket();
        ds.send(dp);
        ds.close();
    }
}
