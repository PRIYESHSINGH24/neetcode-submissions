class Solution {
public:
    string kthDistinct(vector<string>& arr, int k) {
        unordered_map<string, int> freq;

        // Count frequency
        for (string s : arr) {
            freq[s]++;
        }

        // Find kth distinct string
        for (string s : arr) {
            if (freq[s] == 1) {
                k--;
                if (k == 0) {
                    return s;
                }
            }
        }

        return "";
    }
};