class Solution {
    public int rob(int[] nums) {
        int[] dp = new int[nums.length+1];
        Arrays.fill(dp, -1);
        return dpSol(nums, 0, dp);
    }
    public int dpSol(int[] nums, int i, int[] dp){
        dp[0] = dp[1] = -1;
        if(i >= nums.length) return 0;
        if(dp[i] != -1) return dp[i];
        int rob = nums[i] + dpSol(nums, i+2, dp);
        int donotrob = dpSol(nums, i+1, dp);
        return dp[i] = Math.max(rob,donotrob);
    }
}


class Solution {
    public int rob(int[] nums) {
        return recursion(nums,0);
    }
    public int recursion(int[] nums, int i){
        if(i >= nums.length) return 0;
        int rob = nums[i] + recursion(nums, i+2);
        int donotrob = recursion(nums, i+1);
        return Math.max(rob,donotrob);
    }
}
