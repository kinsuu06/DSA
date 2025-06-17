class Solution {
    public int climbStairs(int n) {
        return recursion(n);

    }
    public int recursion(int n){
        if(n < 0){
            return 0;
        }
        if(n == 0) return 1;
        int oneStep = recursion(n-1);
        int twoStep = recursion(n-2);
        return oneStep+twoStep;
    }
}

// DP

class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        return func(n,dp);
    }
    public int func(int n, int[] dp){
        dp[0] = dp[1] = 1;
        if(dp[n] != 0) return dp[n];
        int oneStep = func(n-1,dp);
        int twoStep = func(n-2,dp);
        return dp[n] = oneStep+twoStep;
    }
}
