import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * Created by hust on 2018/2/27.
 */
public class Day31_TCPClient {
    public static void main(String[] args) throws IOException{
        Socket socket = new Socket("127.0.0.1",8000);
        OutputStream os = socket.getOutputStream();
        FileInputStream fi = new FileInputStream("E:\\Java_test\\resource\\picDemo.jpg");
        int len = 0;
        byte[] data = new byte[1024];
        while ((len = fi.read(data)) != -1) {
            os.write(data,0,len);
        }
        InputStream is = socket.getInputStream();
        len = is.read(data);
        System.out.println(new String(data,0,len));
        fi.close();
        socket.close();
    }
}
