import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by hust on 2018/2/27.
 */
public class Day31_TCPServer {
    public static void main(String[] args) throws IOException{
        ServerSocket serverSocket = new ServerSocket(8000);
        Socket socket = serverSocket.accept();
        InputStream in = socket.getInputStream();
        File upload = new File("E:\\Java_test\\resource\\upload");
        if (!upload.exists()) {
            upload.mkdirs();
        }
        FileOutputStream fo = new FileOutputStream(upload + "picDemoR.jpg");
        byte[] data = new byte[1024];
        int len = 0;
        while ((len = in.read(data)) != -1) {
            fo.write(data,0,len);
        }

    }
}
