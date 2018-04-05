package job.zhaohang;

import java.util.Scanner;

public class test2 {
    public static StringBuffer sb = new StringBuffer();
    public static void printPar(int l, int r, char[] str, int count){
        if(l<0 || r<l) return;
        if(l==0&&r==0){
            //System.out.println(str);
            for (char c :
                    str) {
                sb.append(c);
            }
            sb.append(",");
        }else{
            if(l>0){
                str[count]='(';
                printPar(l-1, r, str, count+1);
            }
            if(r>l){
                str[count]=')';
                printPar(l, r-1, str, count+1);
            }
        }

    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        char str[] = new char[count*2];
        printPar(count, count, str, 0);
        sb.deleteCharAt(sb.length() - 1);
        System.out.println(sb.toString());
    }
}
