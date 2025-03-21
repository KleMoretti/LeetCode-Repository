/*给你一个整数数组 nums，和一个整数 k 。
在一个操作中，您可以选择 0 <= i < nums.length 的任何索引 i 。
将 nums[i] 改为 nums[i] + x ，其中 x 是一个范围为 [-k, k] 的任意整数。
对于每个索引 i ，最多 只能 应用 一次 此操作。
nums 的 分数 是 nums 中最大和最小元素的差值。
在对  nums 中的每个索引最多应用一次上述操作后，返回 nums 的最低分数 。*/

import java.util.Arrays;

class Solution {
    public int smallestRangeI(int[] nums, int k) {
        Arrays.sort(nums);
        if(nums[nums.length-1]-nums[0]<=2*k){
            return 0;
        }
        return nums[nums.length-1]-nums[0]-2*k;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {2, 7, 2};
        int k = 1;
        System.out.println(s.smallestRangeI(nums, k));
    }
}