import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by Administrator on 2018/1/13.
 * 有一个抽奖池,该抽奖池中存放了奖励的金额,该抽奖池用一个数组int[] arr = {10,5,20,50,100,200,500,800,2,80,300};
 创建两个抽奖箱(线程)设置线程名称分别为“抽奖箱1”，“抽奖箱2”，随机从arr数组中获取奖项元素并打印在控制台上,格式如下:

 抽奖箱1 又产生了一个 10 元大奖
 抽奖箱2 又产生了一个 100 元大奖
 //.....
 */
public class Day27_test1 {

    private static class box implements Runnable {
        private String name;
        private int[] arr;
        private boolean interrupted;

        public void setInterrupted(boolean b) {
            this.interrupted = b;
        }

        public box(String name,int[] arr) {
            this.name = name;
            this.arr = arr;
        }

        @Override
        public void run() {
            while (!interrupted) {
                Random random = new Random();
                int num = arr[random.nextInt(arr.length)];
                System.out.println("抽奖箱"+ name +" 又产生了一个 " + num + " 元大奖!");
                try {
                    Thread.sleep(800);
                } catch (InterruptedException e) {
                    System.out.println("关闭抽奖箱:" + name + "!");
                }
            }
            }
        }

        public static void main(String[] args) {
            int[] arr = {10,5,20,50,100,200,500,800,2,80,300};
            ExecutorService es = Executors.newCachedThreadPool();
            box box1 = new box("1",arr);
            box box2 = new box("2",arr);
            es.submit(box1);
            es.submit(box2);
            try {
                Thread.sleep(3000);
                box1.setInterrupted(true);
                box2.setInterrupted(true);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            es.shutdownNow();
        }

    }
