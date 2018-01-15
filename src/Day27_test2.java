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
    private static int i = 100;

    private static class door implements Runnable{
        String name;
        private int count= 0;
        private int time;

        public void setInterrupted(boolean interrupted) {
            this.interrupted = interrupted;
        }

        private boolean interrupted;

        public door(String name,int time) {
            this.name = name;
            this.time = time;
        }

        @Override
        public void run() {
            while (!interrupted) {
                if (i > 0) {
                    //lock.lock();
                    getIn();
                    //lock.unlock();
                } else {
                    interrupted = true;
                }

                try {
                    Thread.sleep(time);
                } catch (InterruptedException e) {
                    System.out.println(e);
                }
            }
            System.out.println(name+ " 关闭！");
            System.out.println("从" + name + "入场的员工总共: " + count + " 位员工.");
        }

        public synchronized void getIn() {
            count++;
            Random random = new Random();
            HashSet<Integer> hashSet = new HashSet<>();
            for (int j = 0; j < 7; j++) {
                hashSet.add(random.nextInt(50));
            }
            System.out.println("编号为: " + i-- + " 的员工 从" + name + " 入场! 拿到的双色球彩票号码是:" + hashSet);

        }

        public int getCount() {
            return count;
        }
    }

    public static void main(String[] args) {
        ExecutorService es = Executors.newCachedThreadPool();
        door door1 = new door("前门",200);
        door door2 = new door("后门",100);
        es.submit(door1);
        es.submit(door2);
        try {
            Thread.sleep(30000);
            door1.setInterrupted(true);
            door2.setInterrupted(true);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        es.shutdownNow();
    }

}
