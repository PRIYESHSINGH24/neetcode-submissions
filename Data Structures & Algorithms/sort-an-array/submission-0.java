class Solution {

    // Merges two adjacent sorted halves: [low..mid] and [mid+1..high].
    // Uses a shared temp buffer to avoid repeated allocation / autoboxing.
    private void merge(int[] nums, int low, int mid, int high, int[] temp) {
        int left = low;        // pointer for the left half
        int right = mid + 1;   // pointer for the right half
        int idx = low;         // write position in temp

        // Pick the smaller front element from the two halves each time.
        // '<=' keeps the sort stable (equal elements keep their order).
        while (left <= mid && right <= high) {
            if (nums[left] <= nums[right]) {
                temp[idx++] = nums[left++];
            } else {
                temp[idx++] = nums[right++];
            }
        }

        // Copy whatever is left in the left half (right half is exhausted).
        while (left <= mid) {
            temp[idx++] = nums[left++];
        }

        // Copy whatever is left in the right half (left half is exhausted).
        while (right <= high) {
            temp[idx++] = nums[right++];
        }

        // Write the merged range back into the original array.
        for (int i = low; i <= high; i++) {
            nums[i] = temp[i];
        }
    }

    // Recursively splits the range, then merges the sorted halves back.
    private void mergeSort(int[] nums, int low, int high, int[] temp) {
        if (low >= high) {
            return; // a single element is already sorted
        }

        int mid = low + (high - low) / 2; // overflow-safe midpoint
        mergeSort(nums, low, mid, temp);        // sort left half
        mergeSort(nums, mid + 1, high, temp);   // sort right half
        merge(nums, low, mid, high, temp);      // merge the two halves
    }

    public int[] sortArray(int[] nums) {
        int n = nums.length;
        int[] temp = new int[n];     // allocate once, reuse everywhere
        mergeSort(nums, 0, n - 1, temp);
        return nums;
    }
}