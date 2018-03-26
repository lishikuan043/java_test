package job.toutiao;

import java.util.HashSet;
import java.util.Scanner;

public class test1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.nextLine();
        String s2 = scanner.nextLine();
        int length = Integer.parseInt(s1.split(" ")[0]);
        int cha = Integer.parseInt(s1.split(" ")[1]);
        String[] strings = s2.split(" ");
        //int[] ints = new int[length];
        HashSet<Integer> ints = new HashSet<>();
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < length; i++) {
            ints.add(Integer.parseInt(strings[i]));
            hashSet.add(Integer.parseInt(strings[i]));
        }
        int count = 0;
        for (int num :
                ints) {
            if (hashSet.contains(num - cha) || hashSet.contains(num + cha)) {
                count++;
                hashSet.remove(num);
            }
        }
        System.out.println(count);
    }
}
