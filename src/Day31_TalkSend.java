import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

/**
 * Created by Administrator on 2018/2/26.
 */
public class Day31_TalkSend {
    public static void main(String[] args) throws IOException{
        boolean flag = true;
        InetAddress inetAddress = InetAddress.getByName("127.0.0.1");
        Scanner scanner = new Scanner(System.in);
        while (flag) {
            String input = scanner.nextLine();
            byte[] data = input.getBytes();
            DatagramPacket dp = new DatagramPacket(data,data.length,inetAddress,6000);
            DatagramSocket ds = new DatagramSocket();
            ds.send(dp);
            if (input.equals("bye!"))
            {
                flag = false;
                ds.close();
            }
        }

    }
}
