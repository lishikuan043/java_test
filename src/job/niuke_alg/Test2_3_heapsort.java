package job.niuke_alg;

public class Test2_3_heapsort {

    public static void main(String[] args) {
        int[] b = {154,35,48,36,27,12,44,44,8,14,26,17,28};
        sort(b);
        for (int i : b) {
            System.out.println(i);
        }
    }
    public static void sort(int[] a)
    {
        int N = a.length-1;
        for (int k = N/2; k >= 0; k--)
            sink(a, k, N);
        while (N > 0)
        {
            exch(a, 0, N);
            sink(a, 0, --N);
        }
    }

    private static void exch(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    private static void sink(int[]a,int k,int N)
    {
        while (2*k <= N)
        {
            int j = 2*k;
            if (j < N && less(a,j, j+1)) j++;
            if (!less(a,k, j)) break;
            exch(a,k, j);
            k = j;
        }
    }

    private static boolean less(int[] a, int i, int j)
    {
        return a[i] < a[j];
    }
}
