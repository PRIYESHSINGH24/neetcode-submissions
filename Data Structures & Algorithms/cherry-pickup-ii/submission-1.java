
class Solution {
    public int cherryPickup(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;
        int[][][] dp = new int[r][c][c];
        for (int[][] positions : dp)
            for (int[] next : positions)
                Arrays.fill(next, -1);

        // Base case: both robots are already on the last row.
        for (int col1 = 0; col1 < c; col1++) {
            for (int col2 = 0; col2 < c; col2++) {
                dp[r - 1][col1][col2] = grid[r - 1][col1];
                if (col1 != col2)
                    dp[r - 1][col1][col2] += grid[r - 1][col2];
            }
        }

        for (int row = r - 2; row >= 0; row--) {
            for (int col1 = 0; col1 < c; col1++) {
                for (int col2 = 0; col2 < c; col2++) {
                    int cherries = grid[row][col1];
                    if (col1 != col2) cherries += grid[row][col2];

                    for (int next1 = col1 - 1; next1 <= col1 + 1; next1++) {
                        for (int next2 = col2 - 1; next2 <= col2 + 1; next2++) {
                            if (next1 >= 0 && next1 < c && next2 >= 0 && next2 < c) {
                                dp[row][col1][col2] = Math.max(
                                    dp[row][col1][col2],
                                    cherries + dp[row + 1][next1][next2]
                                );
                            }
                        }
                    }
                }
            }
        }
        return dp[0][0][c - 1];
    }
}