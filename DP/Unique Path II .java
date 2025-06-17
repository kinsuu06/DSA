class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    
        return recursion(obstacleGrid, 0, 0);
    }
    public int recursion(int[][] obstacleGrid, int i, int j){
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        if(i == n-1 && j == m-1 && obstacleGrid[n-1][m-1] != 1) return 1;
        if(i >= n || j >= m) return 0;
        int r = 0;
        int d = 0;
        if(obstacleGrid[i][j] != 1) {
            r = recursion(obstacleGrid, i+1, j);
            d = recursion(obstacleGrid, i, j+1);
        }
        return r + d;
    }
}


class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        int[][] dp = new int[n+1][m+1];
        for(int[] a : dp){
            Arrays.fill(a, -1);
        }
        return dpSol(obstacleGrid, 0, 0, dp);
    }
    public int dpSol(int[][] obstacleGrid, int i, int j, int[][] dp){
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        if(dp[i][j] != -1) return dp[i][j];
        if(i == n-1 && j == m-1 && obstacleGrid[n-1][m-1] != 1) return 1;
        if(i >= n || j >= m) return 0;
        int r = 0;
        int d = 0;
        if(obstacleGrid[i][j] != 1) {
            r = dpSol(obstacleGrid, i+1, j, dp);
            d = dpSol(obstacleGrid, i, j+1, dp);
        }
        return dp[i][j] = r + d;
    }
}
