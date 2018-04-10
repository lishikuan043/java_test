package test;

import java.math.BigInteger;
import java.util.Scanner;

public class test3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = Integer.parseInt(scanner.nextLine());
        String[] strings = scanner.nextLine().split(" ");
        int l1 = Integer.parseInt(strings[0]);
        //int n1 = Integer.parseInt(strings[1]);
        BigInteger n1 = new BigInteger(strings[1]);
        int l2 = Integer.parseInt(strings[2]);
        BigInteger n2 = new BigInteger(strings[3]);
        //int n2 = Integer.parseInt(strings[3]);
        //int m = 10;
        int n = 2;
        int w[] = new int[2];
        w[0] = l1;
        w[1] = l2;
        int p[] = new int[2];
        p[0] = 1;
        p[1] = 200;
        int c[][] = BackPack_Solution(m, n, w, p);
        /*for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                System.out.print(c[i][j] + "\t");
                if (j == m) {
                    System.out.println();
                }
            }
        }*/
        //printPack(c, w, m, n);
        //System.out.println(c[n][m]);
        Integer xx1 = c[n][m]%200;
        Integer xx2 = c[n][m]/200;
        BigInteger x1 = new BigInteger(xx1.toString());
        BigInteger x2 = new BigInteger(xx2.toString());
        //System.out.println(x1 + " " + x2);
        BigInteger kind1 = getkind(x1,n1);
        BigInteger kind2 = getkind(x2,n2);
        //System.out.println(kind1 + " " + kind2);
        BigInteger b1 = new BigInteger(kind1.toString());
        BigInteger b2 = new BigInteger(kind2.toString());
        BigInteger result = b1.multiply(b2);
        String s = "1000000007";
        BigInteger b3 = new BigInteger(s);
        BigInteger out = result.divideAndRemainder(b3)[1];
        System.out.println(out);

    }

    public static BigInteger getNFactorial(BigInteger n){
        if(n.compareTo(new BigInteger("0")) == 0){
            return new BigInteger("1");
        }
        return n.multiply(getNFactorial(n.subtract(new BigInteger("1"))));
    }

    private static BigInteger getkind(BigInteger x1, BigInteger n1) {
        BigInteger l = getNFactorial(n1).divide(getNFactorial(x1).multiply(getNFactorial(n1.subtract(x1))));
        return l;
    }

    /**
     * @param m 表示背包的最大容量
     * @param n 表示商品个数
     * @param w 表示商品重量数组
     * @param p 表示商品价值数组
     */
    public static int[][] BackPack_Solution(int m, int n, int[] w, int[] p) {
        //c[i][v]表示前i件物品恰放入一个重量为m的背包可以获得的最大价值
        int c[][] = new int[n + 1][m + 1];
        for (int i = 0; i < n + 1; i++)
            c[i][0] = 0;
        for (int j = 0; j < m + 1; j++)
            c[0][j] = 0;

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                //当物品为i件重量为j时，如果第i件的重量(w[i-1])小于重量j时，c[i][j]为下列两种情况之一：
                //(1)物品i不放入背包中，所以c[i][j]为c[i-1][j]的值
                //(2)物品i放入背包中，则背包剩余重量为j-w[i-1],所以c[i][j]为c[i-1][j-w[i-1]]的值加上当前物品i的价值
                if (w[i - 1] <= j) {
                    if (c[i - 1][j] < (c[i - 1][j - w[i - 1]] + p[i - 1]))
                        c[i][j] = c[i - 1][j - w[i - 1]] + p[i - 1];
                    else
                        c[i][j] = c[i - 1][j];
                } else
                    c[i][j] = c[i - 1][j];
            }
        }
        return c;
    }
}
