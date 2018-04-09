package job.wangyiyouxi;

import java.util.Scanner;

public class temptest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] strings = s.split(" ");
        int ten = Integer.parseInt(strings[0]);
        int di = Integer.parseInt(strings[1]);
        String result = convex(ten,di);
        System.out.println(result);
    }

    private static String convex(int ten, int di) {
        if (di <= 1) {
            return "error di.";
        }
        int high = 0;
        int temp = ten;
        while (temp >= Math.pow(di,high)) {
            high++;
        }
        int[] ints = new int[high];
        for (int i = high-1; i>=0 ; i--) {
            int k = (int) Math.pow(di,i);
            int m = 0;
            while(temp >= m*k) {
                m++;
            }
            ints[i] = m-1;
            temp = temp - (m-1)*k;
        }
        StringBuffer sb = new StringBuffer();
        for (int i = ints.length-1; i >= 0 ; i--) {
            sb.append(ints[i]);
        }
        return sb.toString();
    }
}
