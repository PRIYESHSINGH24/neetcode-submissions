class Solution {
public:
    /*
    1. Set last element of ret to -1, then fill in B in reverse order via:
    b_k = max(b_(k+1), a_(k+1))
    */
    vector<int> replaceElements(vector<int>& arr) {
        std::vector<int> ret(arr.size());
ret[arr.size() - 1] = -1;

for (int i = ret.size() - 2; i >= 0; i--) {
    ret[i] = ret[i + 1] > arr[i + 1] ? ret[i + 1] : arr[i + 1];
}

return ret;
    }
};