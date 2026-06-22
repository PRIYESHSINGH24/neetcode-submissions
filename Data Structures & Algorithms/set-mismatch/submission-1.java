class Solution {
    public int[] findErrorNums(int[] nums) {
        int i = 0;

        while (i < nums.length) {
            if (nums[i] != nums[nums[i] - 1]) {
                swap(nums, nums[i] - 1, i);
            } else {
                i++;
            }
        }

        int[] res = new int[2];

        for (i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                res[0] = nums[i];
                res[1] = i + 1;
                break;
            }
        }

        return res;
    }

    private void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}