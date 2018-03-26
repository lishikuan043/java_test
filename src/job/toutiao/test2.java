package job.toutiao;

import java.util.Scanner;

public class test2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        System.out.println(get(N));
    }
    private static int get(int i) {
        if (i == 1) return 0;
        if (i == 2) return 1;
        return get(i/3*2) + 1;
    }
}
