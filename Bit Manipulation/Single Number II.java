class Solution {
    public int singleNumber(int[] nums) {
        int ans = 0;
        for(int i=0; i<32; i++){
            int cnt = 0;
            for(int j=0; j<nums.length; j++){
                if((nums[j] & (1<<i)) != 0) cnt++;
            }
            if(cnt % 3 == 1) {
                ans = ans|(1<<i);
            }
        }
        return ans;
    }
}


class Solution {
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        for(int i=1; i<nums.length; i+=3){
            if(nums[i] != nums[i-1]){
                return nums[i-1];
            }
        }
        return nums[nums.length-1];
    }
}
