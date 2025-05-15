class Solution {
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result ^= nums[i];
        }
        return result;
    }
}

// class Solution {
//     public int singleNumber(int[] nums) {
//         HashMap<Integer, Integer> map = new HashMap<>();
//         for(int i : nums){
//             map.put(i, map.getOrDefault(i,0)+1);
//         }
//         for(int val : map.keySet()){
//             if(map.get(val) == 1){
//                 return val;
//             }
//         }
//         return 0;
//     }
// }
