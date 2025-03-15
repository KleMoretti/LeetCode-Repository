
/*给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素。
元素的顺序可能发生改变。然后返回 nums 中与 val 不同的元素的数量。*/
class Solution {
    public int removeElement(int[] nums, int val) {
        int l=nums.length;
        int i=0;
        while(i<l){
            if(nums[i]==val){
                nums[i]=nums[l-1];
                l--;
            }else{
                i++;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {3,2,2,3};
        int val = 3;
        System.out.println(s.removeElement(nums, val));
    }
}
