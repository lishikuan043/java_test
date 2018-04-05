package job.niuke_alg;

/*import java.util.HashSet;
import java.util.Scanner;*/

public class Test2_7_Subsequence {
    public static void main(String[] args) {
        int[] A = {1,5,4,3,2,6,7};
        System.out.println(shortestSubsequence(A,A.length));
/*        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        char[] chars = s.toCharArray();
        HashSet<Character> hashSet = new HashSet<>();
        for (char c :
                chars) {
            if (!hashSet.contains(c)) {
                System.out.print(c);
                hashSet.add(c);
            }
        }*/
    }

    public static int shortestSubsequence(int[] A, int n) {
        // write code here
        int low = 0;
        int high = n - 1;
        int temp = A[0];
        for (int i = 1; i < n; i++) {
            if (A[i] >= temp) {
                temp = A[i];
            }else {
                low = i;
            }
        }
        temp = A[n-1];
        for (int i = n-2; i >= 0; i--) {
            if (A[i] <= temp) {
                temp = A[i];
            }else {
                high = i;
            }
        }
        if (low-high+1 <= 0) {
            return 0;
        }else return low-high+1;
    }
}
