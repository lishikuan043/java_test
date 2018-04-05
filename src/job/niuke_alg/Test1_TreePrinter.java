package job.niuke_alg;

import java.util.*;


class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
    public TreeNode(int val) {
        this.val = val;
    }
}
public class Test1_TreePrinter {
    public int[][] printTree(TreeNode root) {
        // write code here
        ArrayList<List<Integer>> lists = new ArrayList<>();
        lists.add(new ArrayList<Integer>());
        int hight = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode last =  root;
        TreeNode nlast = root;
        TreeNode justOut;
        queue.add(root);
        System.out.println(last.val);
        while (queue.size() != 0){
            justOut = queue.poll();
            lists.get(hight).add(justOut.val);
            //System.out.print(justOut.val);
            if (justOut.left!=null) {
                queue.add(justOut.left);
                nlast = justOut.left;
            }
            if (justOut.right!=null) {
                queue.add(justOut.right);
                nlast = justOut.right;
            }
            if (last.equals(justOut)){
                last = nlast;
                hight++;
                lists.add(new ArrayList<Integer>());
                System.out.println();
            }
        }
        int[][] result = new int[lists.size()-1][];
        for (int i = 0; i < lists.size()-1; i++) {
            result[i] = new int[lists.get(i).size()];
            for (int j = 0; j < lists.get(i).size(); j++) {
                result[i][j] = lists.get(i).get(j);
            }
        }
        return result;
    }
}