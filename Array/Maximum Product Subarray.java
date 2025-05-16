// BRUTE FORCE

class Solution {
    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE;
        for(int i=0; i<nums.length; i++){
            int pro = 1;
            for(int j=i; j<nums.length; j++){
                pro *= nums[j];
                max = Math.max(max, pro);
            }
        }
        return max;
    }
}

// OPTIMISED 

class Solution {
    public int maxProduct(int[] nums) {
       int product = 1;
       int ans = Integer.MIN_VALUE;
       for(int i=0; i<nums.length; i++){
           product *= nums[i];
           ans = Math.max(ans,product);
           if(product == 0){
               product = 1;
           }
       } 
       product = 1;
       for(int i=nums.length-1; i>=0; i--){
           product *= nums[i];
           ans = Math.max(product,ans);
           if(product == 0){
               product = 1;
           }
       }
       return ans;
    }
}
