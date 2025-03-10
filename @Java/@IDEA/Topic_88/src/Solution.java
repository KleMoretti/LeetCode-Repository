class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) {
            return;
        }
        int k = 0;
        for (int i = 0; i < m + n ; ) {
            if (nums1[i] > nums2[k]) {
                for (int j = m + n - 1; j > i; j--) {
                    nums1[j] = nums1[j - 1];
                }
                nums1[i] = nums2[k];
                k++;
            } else {
                i++;
            }
            if (k == n) {
                break;
            }
        }
        if(k < n) {
            for (int i = m + k; i < m + n; i++) {
                nums1[i] = nums2[k];
                k++;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums1 = new int[]{4, 0, 0,0, 0, 0};
        int[] nums2 = new int[]{1, 2, 3, 5, 6};
        solution.merge(nums1, 1, nums2, 5);
        for (int i : nums1) {
            System.out.println(i);
        }
    }
}