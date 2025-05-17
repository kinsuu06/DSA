class Solution {
    public int singleNonDuplicate(int[] nums) {
      int left = 0;
      int h = nums.length-1;
      while(left < h){
        int mid = (left+h)/2;
        if(mid % 2 != 0){
            mid--;
        }
        if(nums[mid] == nums[mid+1]){
            left = mid+2;
        }else{
            h = mid;
        }

      }
      return nums[left];
    }
}
