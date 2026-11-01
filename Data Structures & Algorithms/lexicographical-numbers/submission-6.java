class Solution {
    public int[] lexicalOrder(int n) {
        int[] ans = new int[n];
        int curr = 1;

        for (int i = 0; i < n; i++) {
            ans[i] = curr;

            if (curr <= n / 10) {
                curr *= 10;
            } else {
                while (curr % 10 == 9 || curr >= n) {
                    curr /= 10;
                }
                curr++;
            }
        }

        return ans;
    }
}