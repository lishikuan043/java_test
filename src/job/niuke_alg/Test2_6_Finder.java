package job.niuke_alg;

public class Test2_6_Finder {

    public static void main(String[] args) {
        int[][] mat = {{1,2,3},{4,5,6},{7,8,9},{10,11,12}};
        System.out.println(findX(mat,4,3,3));
    }

    public static boolean findX(int[][] mat, int n, int m, int x) {
        int i = m-1;
        int j = 0;
        while(j<n && i>=0){
            if (mat[j][i] > x) {
                i--;
            }else if (mat[j][i] < x) {
                j++;
            }else {
                return true;
            }
        }
        return false;
    }
}
