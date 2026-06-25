// // using dfs : optimised approach

// class Solution {
//     public int numIslands(char[][] grid) {
//         if(grid == null || grid.length == 0){
//             return 0;
//         }

//         int count = 0;
//         int r = grid.length;
//         int c = grid[0].length;

//         //traverse each cell
//         for(int i = 0 ; i < r ;i++){
//             for(int j = 0 ; j < c ; j++){
//                 if(grid[i][j] == '1'){
//                     count++; // new island discovered
//                     dfs(grid,i,j); //mark entire island visited
//                 }
//             }
//         }

//         return count;
//     }

//     public void dfs(char[][] grid , int row, int col){
        
//         //boundary check
//         if(row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == '0'){
//             return;
//         } 

//         //mark cuuren land as visited
//         grid[row][col] = '0';

//         //explore all 4 direction
//         dfs(grid , row-1 , col); //up
//         dfs(grid , row + 1 , col); //down
//         dfs(grid , row , col-1); //left
//         dfs(grid, row , col+1); //right

//     }
// }

// // using bfs : just for learning
class Solution {
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0){
            return 0;
        }

        int count = 0;
        int r = grid.length;
        int c = grid[0].length;

        int[][] dirs = {
            {1,0}, //down
            {-1,0}, //up
            {0,1}, //right
            {0,-1} //left
        };

        //traverse each cell
        for(int i = 0 ; i < r ;i++){
            for(int j = 0 ; j < c ; j++){
                if(grid[i][j] == '1'){
                    count++; // new island discovered
                    //mark entire island visited
                    Queue<int[]> q = new LinkedList<>();
                    q.offer(new int[]{i,j});
                    grid[i][j] = '0';

                    while(!q.isEmpty()){
                        int[] curr = q.poll();

                        for(int[] k : dirs){
                            int nr = curr[0] + k[0];
                            int nc = curr[1] + k[1];

                            if(nr >= 0 && nc >= 0 && nr < r && nc < c && grid[nr][nc] == '1'){
                                grid[nr][nc] = '0';
                                q.offer(new int[]{nr,nc});
                            }
                        }
                    }
                }
            }
        }

        return count;
    }
}