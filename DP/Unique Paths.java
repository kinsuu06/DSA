class Solution {
    public int uniquePaths(int m, int n) {
        return recursion(m, n, 0, 0);
    }
    public int recursion(int m, int n, int i, int j){
        if(i >= m || j >= n) return 0;
        if(i == m-1 && j == n-1) return 1;
        int d = recursion(m, n, i, j+1);
        int r = recursion(m, n, i+1, j);
        return r+d;
    }
}
//--------------------------------------------------

class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m+1][n+1];
        for(int[] a : dp){
            Arrays.fill(a, -1);
        }
        return dpSol(m, n, 0, 0, dp);
    }
    public int dpSol(int m, int n, int i, int j, int[][] dp){
        if(i >= m || j >= n) return 0;
        if(i == m-1 && j == n-1) return 1;
        if(dp[i][j] != -1) return dp[i][j];
        int d = dpSol(m, n, i, j+1, dp);
        int r = dpSol(m, n, i+1, j, dp);
        return dp[i][j] = r+d;
    }
}
