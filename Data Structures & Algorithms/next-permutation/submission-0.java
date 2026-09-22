class Solution {
    public void swap(int[] nums, int i, int j) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }

    public void reverse(int[] nums, int start) {
        int k = nums.length - 1;

        while (start < k) {
            swap(nums, start, k);
            start++;
            k--;
        }
    }

    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;

        // STEP 1: Find the breakpoint
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }

        if (i >= 0) {
            int j = nums.length - 1;

            // STEP 2: Find the smallest number greater than nums[i]
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }

            // STEP 3: Swap
            swap(nums, i, j);
        }

        // STEP 4: Reverse the suffix
        reverse(nums, i + 1);
    }
}