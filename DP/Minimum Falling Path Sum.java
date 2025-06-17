class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int min = Integer.MAX_VALUE;
        int[][] dp = new int[n+1][m+1];
        for(int[] a : dp){
            Arrays.fill(a, -1000);
        }
        for(int i=0; i<m; i++){
            min = Math.min(min, dpSol(matrix, 0, i, dp));
        }
        return min;
    }
    public int dpSol(int[][] matrix, int i, int j, int[][] dp){
        int n = matrix.length;
        int m = matrix[0].length;
        if(j < 0 || i >= n || j >= m) return Integer.MAX_VALUE;
        if(i == n-1 && j < m) return matrix[i][j];
        if(dp[i][j] != -1000) return dp[i][j];
        int d = dpSol(matrix, i+1, j, dp);
        int r = dpSol(matrix, i+1, j+1, dp);
        int l = dpSol(matrix, i+1, j-1, dp);
        return dp[i][j] = matrix[i][j] + Math.min(d,Math.min(l,r));
    }
}
