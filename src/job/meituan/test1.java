package job.meituan;

import java.util.Scanner;

public class test1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.nextLine();
        String s2 = scanner.nextLine();
        int times = s1.length() - s2.length() + 1;
        int sum = 0;
        for (int i = 0; i < times; i++) {
            String ss1 = s1.substring(i,i+s2.length());
            sum += getDis(ss1,s2);
        }
        System.out.println(sum);
    }

    private static int getDis(String s1, String s2) {
        int count = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                count++;
            }
        }
        return count;
    }
}
