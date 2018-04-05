package job.niuke_alg;

public class Test2_4_ScaleSort {
    public static void main(String[] args) {
        Test2_4_ScaleSort test2_4_scaleSort = new Test2_4_ScaleSort();
        int[] ints = {0,2,1,4,3,6,5,8,7,10,9};
        for (int i : test2_4_scaleSort.sortElement(ints,11,2)
                ) {
            System.out.println(i);
        }
    }
    public int[] sortElement(int[] A, int n, int k) {
        int[] result = new int[n];
        //int[] temp = new int[n];
        int[] heap = new int[k];
        //System.arraycopy(A,0,temp,0,n);
        for (int i = 0; i < k; i++) {
            heap[i] = A[i];
        }
        sort(heap);
        for (int i = k; i < n; i++) {
            result[i-k] = heap[0];
            heap[0] = A[i];
            sort(heap);
        }
        for (int i = 0; i < k; i++) {
            result[n-k+i] = heap[i];
        }
        return result;
    }

    private void sort(int[] a) {
        int N = a.length-1;
        for (int i = N/2; i >= 0; i--) {
            sink(a,i,N);
        }
        while (N > 0) {
        swap(a,0,N);
        sink(a,0,--N);
        }
    }


    private void sink(int[] a,int i,int N) {
        while(2*i<=N) {
            int j = 2*i;
            if (j < N && a[j] < a[j+1]) j++;
            if (a[i] >= a[j]) break;
            swap(a,i,j);
            i=j;
        }
    }

    private void swap(int[] a,int i,int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
