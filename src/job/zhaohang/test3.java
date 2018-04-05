package job.zhaohang;

import java.util.Scanner;

public class test3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        int mod = input%3;
        int div = input/3;
        if (input == 0) {
            System.out.println(0);
        }else if (input == 1) {
            System.out.println(0);
        }else if (input == 2) {
            System.out.println(1);
        }else if (input == 3) {
            System.out.println(2);
        }else if (input == 4) {
            System.out.println(4);
        }else if (input == 5) {
            System.out.println(6);
        } else if (mod == 0) {
            System.out.println(pow(new Long( String.valueOf(3) ),div));
        }else if (mod == 1) {
            System.out.println(pow(new Long( String.valueOf(3) ),div-1)*4);
        }else {
            System.out.println(pow(new Long( String.valueOf(3) ),div)*2);
        }
    }

    public static long pow(long x,int n){

        if(n==0)
            return 1;
        else{

            //判断n的奇偶
            if(n%2==0)
                return pow(x*x, n/2);
            else
                return pow(x*x, (n-1)/2)*x;

        }
    }
}
