class Solution {
public:
    int memo[46] = {0};
    int climbStairs(int n) {
        if (n <= 1){
            return 1;
        }else if (n == 2){
            return 2;
        }
        if (memo[n] != 0) return memo[n];
        int ra1 = climbStairs(n -1);
        int ra2 = climbStairs(n-2);
        int ans = ra1 + ra2;
        return memo[n] = ans;        
    }
};
