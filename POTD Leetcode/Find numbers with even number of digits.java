class Solution {
    public int findNumbers(int[] nums) {
        int ans = 0;
        for(int i=0; i<nums.length; i++){
            if(digits(nums[i]) % 2 == 0){
                ans++;
            }
        }
        return ans;
    }
    
    public int digits(int n){
        int count = 0;
        while(n>0){
            int rem = n%10;
            count++;
            n /= 10;
        }
        return count;
    }
}
