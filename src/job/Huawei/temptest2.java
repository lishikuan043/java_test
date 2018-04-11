package job.Huawei;

import java.util.Scanner;
import java.util.TreeSet;

public class temptest2 {
    public static void main(String[] args) throws Exception{
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()) {
            int n = Integer.parseInt(scanner.nextLine());
            TreeSet<Integer> treeSet = new TreeSet<>();
            for (int i = 0; i < n; i++) {
                treeSet.add(Integer.parseInt(scanner.nextLine()));
            }
            for (int i :
                    treeSet) {
                System.out.println(i);
            }
        }
    }
}
