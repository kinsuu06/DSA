class Solution {
    public void rotate(int[] nums, int k) {
        k = k%nums.length;
        func(nums,0, nums.length-1);
        func(nums,0,k-1);
        func(nums, k, nums.length-1);
    }
    public void func(int[] nums,int i, int j){
         while(i < j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }

}
