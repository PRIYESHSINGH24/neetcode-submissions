class Solution {
public:
    int mySqrt(int x) {
        int s = 0;
        int e = x;
        int ans = 0;
        while (s <= e ){

            int mid = (s+e)/2;
           long long me = 1LL * mid * mid;
            if (me == x){
                return mid;
            }
            else if (me > x){
                e = mid-1;
            } else {
                ans = mid;
                s = mid+1;
            }
            
        }
        return ans;
        
    }
};