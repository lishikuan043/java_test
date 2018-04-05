package job.wangyiyouxi;

import java.util.Scanner;

public class test4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] strings = s.split(" ");
        int hang = Integer.parseInt(strings[0]);
        int lie = Integer.parseInt(strings[1]);
        int pos_hang = Integer.parseInt(strings[2]);
        int pos_lie = Integer.parseInt(strings[3]);
        int[][] ints = new  int[hang][lie];
        for (int i = 0; i < hang; i++) {
            for (int j = 0; j < lie; j++) {
                ints[i][j] = scanner.nextInt();
            }
        }
        WeightedQuickUnionUF w = new WeightedQuickUnionUF(hang*lie +1);
        for (int i = 0; i < lie; i++) {
            w.union(ints[0][i],0);
        }
        for (int i = 0; i < hang; i++) {
            for (int j = 0; j < lie; j++) {
                ints[i][j] = scanner.nextInt();
            }
        }
    }

   static class WeightedQuickUnionUF {
        private int[] parent;   // parent[i] = parent of i
        private int[] size;     // size[i] = number of sites in subtree rooted at i
        private int count;      // number of components

        public WeightedQuickUnionUF(int n) {
            count = n;
            parent = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        public int count() {
            return count;
        }

        public int find(int p) {
            validate(p);
            while (p != parent[p])
                p = parent[p];
            return p;
        }

        // validate that p is a valid index
        private void validate(int p) {
            int n = parent.length;
            if (p < 0 || p >= n) {
                throw new IllegalArgumentException("index " + p + " is not between 0 and " + (n-1));
            }
        }

        public boolean connected(int p, int q) {
            return find(p) == find(q);
        }

        public void union(int p, int q) {
            int rootP = find(p);
            int rootQ = find(q);
            if (rootP == rootQ) return;

            // make smaller root point to larger one
            if (size[rootP] < size[rootQ]) {
                parent[rootP] = rootQ;
                size[rootQ] += size[rootP];
            }
            else {
                parent[rootQ] = rootP;
                size[rootP] += size[rootQ];
            }
            count--;
        }
    }
}
