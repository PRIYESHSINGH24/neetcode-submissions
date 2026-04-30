class Solution {
public:
    int search(vector<int>& arr, int target) {
        int start = 0;
        int end = arr.size()-1  ;
        while (start <= end){
            int mididx = (start+end)/2;
            int midele = arr[mididx];
            if (midele == target){
                return mididx;
            } 
            else if (midele > target){
                end = mididx - 1;
            }
            else {
                start = mididx+1;
            }
            
        }
        return -1;


        
    }
};
