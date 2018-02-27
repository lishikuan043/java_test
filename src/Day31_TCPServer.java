import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

/**
 * Created by hust on 2018/2/27.
 */
public class Day31_TCPServer {
    public static void main(String[] args) throws IOException{
        ServerSocket serverSocket = new ServerSocket(8000);
        while (true) {
            Socket socket = serverSocket.accept();
            new Thread(new uploadThread(socket)).start();
        }
    }
}

class uploadThread implements Runnable {
    private Socket socket;

    public uploadThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            InputStream in = socket.getInputStream();
            File upload = new File("E:\\Java_test\\resource\\upload");
            if (!upload.exists()) {
                upload.mkdirs();
            }
            String filename = socket.getInetAddress().getHostName() + System.currentTimeMillis() + new Random().nextInt(999999) + ".jpg";
            FileOutputStream fo = new FileOutputStream(upload + File.separator + filename);
            byte[] data = new byte[1024];
            int len = 0;
            while ((len = in.read(data)) != -1) {
                fo.write(data,0,len);
            }
            OutputStream os = socket.getOutputStream();
            String ans = "收到图片:" + filename;
            os.write(ans.getBytes(),0,ans.getBytes().length);
            fo.close();
            socket.close();
        } catch (IOException e) {
            System.out.println(e);
        }

    }
}
