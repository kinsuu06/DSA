class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int ans  = 0;
        for(int i=0; i<n; i++){
            ans^= nums[i];
        }
        for(int i=1; i<=n; i++){
            ans ^= i;
        }
        return ans;
    }
}

// class Solution {
//     public int missingNumber(int[] nums) {
//         int n = nums.length;
//         int ans  = 0, sum=0;
//         for(int i=0; i<n; i++){
//             ans += nums[i];
//         }
//         for(int i=1; i<=n; i++){
//             sum += i;
//         }
//         return sum-ans;
//     }
// }
