package job.niuke_alg;

public class Test2_3_heapsort {

    public static void main(String[] args) {
        int[] b = {1,2,5,7,3,4,5,6,7};
        sort(b);
        for (int i : b) {
            System.out.print(i);
        }
    }
    public static void sort(int[] a)
    {
        int N = a.length-1;
        for (int k = N/2; k >= 1; k--)
            sink(a, k, N);
        while (N > 1)
        {
            exch(a, 1, N);
            sink(a, 1, --N);
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
