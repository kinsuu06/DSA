class Solution {
    public boolean checkPrimeFrequency(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i : nums){
            map.put(i, map.getOrDefault(i,0)+1);
        }
        for(int i : map.values()){
            if(isPrime(i)){
                return true;
            }
        }
        return false;
    }
    public boolean isPrime(int n){
        if(n < 2) return false;
        for(int i=2; i<n; i++){
            if(n%i == 0) return false;
        }
        return true;
    }
}
