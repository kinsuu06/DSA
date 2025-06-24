class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        Set<Integer> arr = new HashSet<>();
        for(int i=0; i<nums.length; i++){
            for(int j=0; j<nums.length; j++){
                if(Math.abs(j-i) <= k  && nums[j] == key){
                    arr.add(i);
                    arr.add(j);
                }
            }
        }
        ArrayList<Integer> arr1 = new ArrayList<>();
        for(int i: arr) arr1.add(i);

        Collections.sort(arr1);

        return arr1;
    }
}
