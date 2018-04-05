package job.wangyi;

import java.util.Scanner;

public class test3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] strings = s.split(" ");
        int x1 = Integer.parseInt(strings[0]);
        int x2 = Integer.parseInt(strings[1]);
        System.out.println(num(x1,x2));
    }

    public static int num(int n, int k){
        int count = 0;
        for(int x=n;x>0;x--){
            for(int y=n;y>0;y--){
                if((x%y>k)||(x%y==k)){
                    count++;
                }
            }
        }
        return count;
    }
}
