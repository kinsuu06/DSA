class Solution {
    public int divide(int dividend, int divisor) {
        if(dividend == divisor) return 1;
        boolean sign = true;
        if(dividend < 0 && divisor > 0) sign = false;
        if(dividend > 0 && divisor < 0) sign = false;
        long n = Math.abs((long)dividend);
        long d = Math.abs((long)divisor);

        int ans = 0;
        while(n >= d){
            int cnt = 0;
            while(n >= (d<<(cnt+1))){
                cnt++;
            }
            ans  += 1<<cnt;
            n -= (d<<cnt);
        }
        if(ans == (1<<31) && sign==true) return Integer.MAX_VALUE;
        if(ans == (1<<31) && sign==false) return Integer.MIN_VALUE;
        if(sign){
            return ans;
        }
        return -ans;
    }
}
