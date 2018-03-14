package job;

public class MinDistance {
    public static int findminCost(String s1,String s2,int dc,int ic,int uc) {
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        int length1 = s1.length();
        int length2 = s2.length();
        int[][] costs = new int[length1 + 1][length2 + 1];
        for(int i = 0;i < length1;i++) {
            costs[i][0] = dc * i;
        }
        for(int j = 0;j < length2;j++) {
            costs[0][j] = ic * j;
        }
        for(int i = 1;i < length1 +1;i++) {
            for(int j=1;j < length2 + 1;j++) {
                int case1 = costs[i][j-1] + ic;
                int case2 = costs[i-1][j] + dc;
                int case3 = 0;
                if (chars1[i-1]==chars2[j-1]) {
                    case3 = costs[i-1][j-1];
                } else {
                    case3 = costs[i-1][j-1] + uc;
                }
                costs[i][j] = Math.min(Math.min(case1,case2),case3);
            }
        }
        return costs[length1][length2];
    }

    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "adc";
        System.out.println(findminCost(s1,s2,3,5,1));
    }
}
