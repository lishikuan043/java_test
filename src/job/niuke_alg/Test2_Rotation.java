package job.niuke_alg;

public class Test2_Rotation {
    public static boolean chkRotation(String A,int lena,String B,int lenb) {
        if (lena != lenb) {
            return false;
        }
        String AA = A + A;
        if (AA.lastIndexOf(B) == -1) {
            return false;
        }else {
            return true;
        }
    }

    public static void main(String[] args) {
        System.out.println(chkRotation("12345",5,"34521",5));
    }
}
