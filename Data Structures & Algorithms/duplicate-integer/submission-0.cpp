class Solution {
public:
    bool hasDuplicate(vector<int>& nums) {
        int n = nums.size();
        int i = 0;
        sort(nums.begin(), nums.end());
        while (i < n-1){
         if (nums[i] == nums[i+1]){
            return true;
         } else {
            i++; 
         }
         }
         return false;
    }
};