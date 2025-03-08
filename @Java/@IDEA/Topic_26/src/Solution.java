class Solution {
    public int removeDuplicates(int[] nums) {
        int i=nums.length;
        for(int j=0;j<i-1;j++){
            if(nums[j]==nums[j+1]){
                for(int k=j;k<i-1;k++){
                    nums[k]=nums[k+1];
                }
                i--;
                j--;
            }
        }
        return i;
    }
}