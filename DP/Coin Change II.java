// RECURSION 

class Solution {
    public int change(int amount, int[] coins) {
        return coin(amount,coins,0);
    }
    public int coin(int amount,int[]coins,int i){
        if(amount == 0){
            return 1;
        }
        if(i >= coins.length) return 0;
        int inc = 0,exc = 0;
        if(amount >= coins[i]){
            inc = coin(amount-coins[i],coins,i);
        }
        exc = coin(amount,coins,i+1);
        return inc+exc;
    }
}


// DP


class Solution {
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length+1][amount+1];
        for(int[] a : dp){
            Arrays.fill(a, -1);
        }
        return coin(amount,coins,0, dp);
    }
    public int coin(int amount,int[]coins,int i,int[][] dp){
        if(amount == 0){
            return 1;
        }
        if(i >= coins.length) return 0;
        if(dp[i][amount] != -1) return dp[i][amount];
        int inc = 0,exc = 0;
        if(amount >= coins[i]){
            inc = coin(amount-coins[i],coins,i, dp);
        }
        exc = coin(amount,coins,i+1, dp);
        return dp[i][amount] = inc+exc;
    }
}
