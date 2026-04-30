class Solution {
public:

    int findPivot(vector<int>& nums) {
        int s = 0, e = nums.size() - 1;

        while (s < e) {
            int mid = s + (e - s) / 2;

            if (nums[mid] > nums[e]) {
                s = mid + 1;
            } else {
                e = mid;
            }
        }
        return s;
    }

    int binarySearch(vector<int>& nums, int s, int e, int target) {
        while (s <= e) {
            int mid = s + (e - s) / 2;

            if (nums[mid] == target) return mid;
            else if (nums[mid] < target) s = mid + 1;
            else e = mid - 1;
        }
        return -1;
    }

    int search(vector<int>& nums, int target) {
        int pivot = findPivot(nums);

        // left part
        if (target >= nums[pivot] && target <= nums[nums.size()-1]) {
            return binarySearch(nums, pivot, nums.size()-1, target);
        } else {
            return binarySearch(nums, 0, pivot-1, target);
        }
    }
};