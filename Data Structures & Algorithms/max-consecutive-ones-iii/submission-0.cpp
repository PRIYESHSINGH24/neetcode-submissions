class Solution {
public:
    int longestOnes(vector<int>& nums, int k) {
        int i = 0;
        int j = 0;
        int zc = 0;
        int ans = 0;
        while(i < nums.size()){
            if (nums[i] == 0){
                zc++;
            }
            while (zc > k){
                if (nums[j] == 0){
                    zc--;
                } j++;


            }
            ans = max(ans,i-j+1);
            i++;
        }
        return ans;
        
    }
};