package test;

public class test2 {
    public static int find(int all,int[] ints) {
        int space = all;
        for (int i :
                ints) {
            space = space - i;
        }
        int ar = space - (ints.length - 1);
        int poi = ints.length + 1;
        return poi * ar;
    }

    public static void main(String[] args) {
        int all = 7;
        int[] ints = {1,3};
        System.out.println(find(all,ints));
    }
}
