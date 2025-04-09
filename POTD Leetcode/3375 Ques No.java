class Solution {
    public int minOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int count = 0;
        for(int i=nums.length-1; i>0; i--){
            if(nums[i] > nums[i-1]){
                count++;
            }
        }
        if(nums[0] == k){
            return count;
        }else if(nums[0] > k){
            return count+1;
        }
        return -1;
    }
}
