package job.niuke_alg;

public class Test2_2_Mergesort {

    public static void main(String[] args) {
        int[] b = {1,2,5,7,3,4,5,6,7};
        b = mergeSort(b,b.length-1);
        for (int i : b) {
            System.out.print(i);
        }
    }

    public static int[] mergeSort(int[] A, int n) {
        // write code here
        int[] result = new int[n];
        sort(A,result,0,n-1);
        return A;
    }

    private static void sort(int[] A,int[]copy,int start,int end) {
        if (end<=start) return;
        int mid = start + (end - start)/2;
        sort(A,copy,start,mid);
        sort(A,copy,mid+1,end);
        merge(A,copy,start,mid,end);
    }

    private static void merge(int[] a,int[] aux,int lo,int mid,int hi) {
        for (int k = lo; k <= hi; k++)
            aux[k] = a[k];
        int i = lo, j = mid+1;
        for (int k = lo; k <= hi; k++)
        {
            if (i > mid) a[k] = aux[j++];
            else if (j > hi) a[k] = aux[i++];
            else if (aux[j]<aux[i]) a[k] = aux[j++];
            else a[k] = aux[i++];
        }
    }

}
