class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for(int i : weights){
            sum += i;
            max = Math.max(max, i);
        }
        int l = max;
        int h = sum;
        while(l <= h){
            int mid = (l+h)/2;
            if(isitPossible(weights, days, mid)){
                h = mid-1;
            }else{
                l = mid+1;
            }
        }
        return l;
    }
    public boolean isitPossible(int[] weights, int days, int mid){
        int load = 0;
        int d = 1;
        for(int i=0; i<weights.length; i++){
            if(load + weights[i] > mid){
                d++;
                load = weights[i];
            }else{
                load += weights[i];
            }
        }
        
        return d <= days;
    }
}
