import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

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

    public int[][] allCellsDistOrder2(int rows, int cols, int rCenter, int cCenter) {
        int[][] ret = new int[rows * cols][];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                ret[i * cols + j] = new int[]{i, j};
            }
        }
        Arrays.sort(ret, (a, b) ->
                (Math.abs(a[0] - rCenter) + Math.abs(a[1] - cCenter)) - (Math.abs(b[0] - rCenter) + Math.abs(b[1] - cCenter)));
        return ret;
    }

    public int[][] allCellsDistOrder3(int rows, int cols, int rCenter, int cCenter) {
        int maxDist = Math.max(rCenter, rows - 1 - rCenter) + Math.max(cCenter, cols - 1 - cCenter);
        List<List<int[]>> bucket = new ArrayList<List<int[]>>();
        for (int i = 0; i <= maxDist; i++) {
            bucket.add(new ArrayList<int[]>());
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int d = dist(i, j, rCenter, cCenter);
                bucket.get(d).add(new int[]{i, j});
            }
        }
        int[][] ret = new int[rows * cols][];
        int index = 0;
        for (int i = 0; i <= maxDist; i++) {
            for (int[] it : bucket.get(i)) {
                ret[index++] = it;
            }
        }
        return ret;
    }

    public int dist(int r1, int c1, int r2, int c2) {
        return Math.abs(r1 - r2) + Math.abs(c1 - c2);
    }
}