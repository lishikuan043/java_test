import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by Administrator on 2018/1/15.
 * 某公司组织年会,会议入场时有两个入口,在入场时每位员工都能获取一张双色球彩票,假设公司有100个员工,利用多线程模拟年会入场过程,
 并分别统计每个入口入场的人数,以及每个员工拿到的彩票的号码。线程运行后打印格式如下：
 编号为: 2 的员工 从后门 入场! 拿到的双色球彩票号码是: [17, 24, 29, 30, 31, 32, 07]
 编号为: 1 的员工 从后门 入场! 拿到的双色球彩票号码是: [06, 11, 14, 22, 29, 32, 15]
 //.....
 从后门入场的员工总共: 13 位员工
 从前门入场的员工总共: 87 位员工
 */
public class Day27_test2 {
    private static class door implements Runnable {
        private static int n = 100;
        private int front = 0;
        private int back = 0;

        @Override
        public void run() {
            while (true) {
                synchronized (this) {
                    if (n > 0) {
                        if (Thread.currentThread().getName().equals("前门")) {
                            System.out.println("编号为:" + n + "的员工从 " + Thread.currentThread().getName() +  " 入场! 拿到的双色球彩票号码是:" + Arrays.toString(getNum()));
                            n--;
                            front++;
                            try {
                                Thread.sleep(100);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        } else if (Thread.currentThread().getName().equals("后门")) {
                            System.out.println("编号为:" + n + "的员工从 " + Thread.currentThread().getName() +  " 入场! 拿到的双色球彩票号码是:" + Arrays.toString(getNum()));
                            n--;
                            back++;
                            try {
                                Thread.sleep(200);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    } else if (n == 0) {
                        System.out.println("从 前门 入场的员工总共: " + front + " 位员工.");
                        System.out.println("从 后门 入场的员工总共: " + back + " 位员工.");
                        n--;
                    } else if (n < 0) {
                        return;
                    }
                }
            }
        }

        private int[] getNum() {
            Random random = new Random();
            int[] ints = new int[7];
            for (int i = 0; i < 7; i++) {
                ints[i] = random.nextInt(50);
            }
            return ints;
        }
    }

    public static void main(String[] args) {
        door d = new door();
        Thread t1 = new Thread(d,"前门");
        Thread t2 = new Thread(d,"后门");
        t1.start();
        t2.start();
    }

}
