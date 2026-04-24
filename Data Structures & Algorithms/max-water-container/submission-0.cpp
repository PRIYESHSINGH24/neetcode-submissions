class Solution {
public:
    int maxArea(vector<int>& heights) {
        int ans = 0;
        int n = heights.size();

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int h = min(heights[i], heights[j]); // height
                int w = j - i;                       // width
                ans = max(ans, h * w);
            }
        }
        return ans;
    }
};