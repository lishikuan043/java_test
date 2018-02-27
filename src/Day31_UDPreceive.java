import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * Created by Administrator on 2018/2/25.
 * 一个标准的UDP接收端。
 */
public class Day31_UDPreceive {
    public static void main(String[] args) throws IOException{
        DatagramSocket ds = new DatagramSocket(6000);
        byte[] data = new byte[1024];
        DatagramPacket dp = new DatagramPacket(data,data.length);
        ds.receive(dp);
        String ip = dp.getAddress().getHostAddress();
        System.out.println(new String(data,0,dp.getLength())+" from "+ ip + ":" + dp.getPort());
        ds.close();
    }
}
