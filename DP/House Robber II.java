import java.util.Arrays;

class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];

        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        int case1 = recursion(nums, 0, n - 1, dp);

        Arrays.fill(dp, -1); 
        int case2 = recursion(nums, 1, n, dp);

        return Math.max(case1, case2);
    }

    public int recursion(int[] nums, int i, int n, int[] dp) {
        if (i >= n) return 0;
        if (dp[i] != -1) return dp[i];

        int rob = nums[i] + recursion(nums, i + 2, n, dp);
        int dontRob = recursion(nums, i + 1, n, dp);

        return dp[i] = Math.max(rob, dontRob);
    }
}
