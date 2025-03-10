import java.util.Arrays;

class Solution {
    public int[][] allCellsDistOrder(int rows, int cols, int rCenter, int cCenter) {
        int max1=Math.max(Math.abs(rCenter-0)+Math.abs(cCenter-0),Math.abs(rCenter-0)+Math.abs(cCenter-cols-1));
        int max2=Math.max(Math.abs(rCenter-rows-1)+Math.abs(cCenter-0),Math.abs(rCenter-rows-1)+Math.abs(cCenter-cols-1));
        int max=Math.max(max1,max2);
        int[][] res = new int[rows * cols][];
        int count = 0;
        for (int k = 0; k <= max; k++) {
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (Math.abs(rCenter - i) + Math.abs(cCenter - j) == k) {
                        res[count] = new int[]{i, j};
                        count++;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] res = s.allCellsDistOrder(3, 5, 2, 3);
        for (int[] re : res) {
            System.out.println(Arrays.toString(re));
        }
    }
}