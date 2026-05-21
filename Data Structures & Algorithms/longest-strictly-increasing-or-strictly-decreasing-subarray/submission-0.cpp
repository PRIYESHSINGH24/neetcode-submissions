class Solution {
public:
    int longestMonotonicSubarray(vector<int>& nums) {
        int ans = 0;
        int prev = nums[0];
        int curr_len = 0;

        for(int i = 1; i < nums.size(); i++){
            int &x = nums[i];

            if(x > prev){
                if(curr_len >= 0) ++curr_len;
                else curr_len = 1;

                ans = max(curr_len, ans);
            }
            else if(x < prev){
                if(curr_len <= 0) --curr_len;
                else curr_len = -1;

                ans = max(abs(curr_len), ans);
            }
            else{
                curr_len = 0;
            }

            prev = x;
        }
        return ans + 1;
    }
};