package job;

public class HeapSort {
    public static void main(String[] args) {
        int[] b = {154,35,48,1,2,5,36,27,12,44,44,8,14,26,17,28};
        sort(b);
        for (int i : b) {
            System.out.println(i);
        }
    }

    public static void sort(int[] a) {
        int N = a.length - 1;
        for (int i = N/2; i >= 0 ; i--) {
            sink(a,i,N);
        }
        while(N > 0) {
            swap(a,0,N);
            sink(a,0,--N);
        }
    }

    public static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void sink(int[] a, int i, int n) {
        while(2*i <= n) {
            int j = 2*i;
            if (j<n && a[j]<a[j+1]) j++;
            if (a[i] >= a[j]) break;
            swap(a,i,j);
            i = j;
        }
    }

}
