/*例如，arr = [1,2,3] 的下一个排列是 [1,3,2] 。
类似地，arr = [2,3,1] 的下一个排列是 [3,1,2] 。
而 arr = [3,2,1] 的下一个排列是 [1,2,3] ，因为 [3,2,1] 不存在一个字典序更大的排列。
给你一个整数数组 nums ，找出 nums 的下一个排列。
必须 原地 修改，只允许使用额外常数空间。
* */



class Solution {
    public void nextPermutation(int[] nums) {
        int j=-1;
        for(int i=nums.length-2;i>=0;i--){
            if(nums[i]<nums[i+1]){
                j=i;
                break;
            }
        }
        if(j==-1){
            reverse(nums,0,nums.length-1);
            return ;
        }else{
            for(int i=nums.length-1;i>j;i--){
                if(nums[i]>nums[j]){
                    int temp=nums[i];
                    nums[i]=nums[j];
                    nums[j]=temp;
                    break;
                }
            }
            reverse(nums,j+1,nums.length-1);
        }
    }

    private void reverse(int[] nums, int i, int i1) {
        while (i<i1){
            int temp=nums[i];
            nums[i]=nums[i1];
            nums[i1]=temp;
            i++;
            i1--;
        }
    }
}
