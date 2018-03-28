package job.niuke_alg;

public class Test2_5_ThreeColor {

    public static void main(String[] args) {
        Test2_5_ThreeColor t = new Test2_5_ThreeColor();
        int[] a = {2,2,0,2,0};
        t.sortThreeColor(a,a.length);
        for (int i :
                a) {
            System.out.println(i);
        }
    }

    public int[] sortThreeColor(int[] A, int n) {
        // write code here
        int zero = 0;
        int now = 0;
        int two = n - 1;
        while(now <= two) {
            if (A[now] == 0) {
                int temp = A[now];
                A[now] = A[zero];
                A[zero] = temp;
                zero++;
                now++;
            }else if (A[now] == 2) {
                int temp = A[now];
                A[now] = A[two];
                A[two] = temp;
                two--;
                //now++;
            }else now++;
        }
        return A;
    }

}
