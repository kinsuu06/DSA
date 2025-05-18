class Solution {
    public int findMin(int[] nums) {
        int min = Integer.MAX_VALUE;
        int l = 0;
        int h = nums.length-1;
        while(l < h){
            int mid = (l+h)/2;
            if(nums[mid] >= nums[l]){
                min = Math.min(min, nums[l]);
                l = mid+1;
            }else if(nums[mid] <= nums[h]){
                min = Math.min(min, nums[mid]);
                h = mid - 1;
            }
        }
        return min;
    }
}
