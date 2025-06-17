class Solution {
    public int minPathSum(int[][] grid) {
        return recursion(grid, 0, 0);
    }
    public int recursion(int[][] grid, int i, int j){
        int n = grid.length;
        int m = grid[0].length;
        if(i >= n || j >= m) return Integer.MAX_VALUE;
        if(i == n-1 && j == m-1) return grid[i][j];
        int d = recursion(grid, i+1, j);
        int r = recursion(grid, i, j+1);
        return grid[i][j]+Math.min(d, r);
    }
}


class Solution {
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n+1][m+1];
        for(int[] a : dp){
            Arrays.fill(a, -1);
        }
        return dpSol(grid, 0, 0, dp);
    }
    public int dpSol(int[][] grid, int i, int j, int[][] dp){
        int n = grid.length;
        int m = grid[0].length;
        if(i >= n || j >= m) return Integer.MAX_VALUE;
        if(i == n-1 && j == m-1) return grid[i][j];
        if(dp[i][j] != -1) return dp[i][j];
        int d = dpSol(grid, i+1, j, dp);
        int r = dpSol(grid, i, j+1, dp);
        return dp[i][j] = grid[i][j]+Math.min(d, r);
    }
}
