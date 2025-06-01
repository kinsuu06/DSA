class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        int totalSubset = 1<<n;
        for(int num=0; num<totalSubset; num++){
            List<Integer> l = new ArrayList<>();
            for(int i=0; i<n; i++){
                if((num & (1<<(i))) != 0){
                    l.add(nums[i]);
                }
            }
            ans.add(l);
        }
        return ans;
    }
}
