class Solution {
    public int sumSubarrayMins(int[] arr) {
        int[] nse = nse(arr);
        int[] psee = psee(arr);
        long sum = 0;
        long mod = 1000000007;
        int n = arr.length;
        for(int i=0; i<n; i++){
            long l = i-psee[i];
            long r = nse[i] - i;
            long total = (l*r*arr[i])%mod;
            sum = (sum%mod + total%mod)%mod;
        }
        return (int)(sum%mod);
    }
    public int[] nse(int[] arr){
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i=n-1; i>=0; i--){
            while(!st.isEmpty() && arr[i] <= arr[st.peek()]){
                st.pop();
            }
            ans[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        return ans;
    }
    public int[] psee(int[] arr){
        int n = arr.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<n; i++){
            while(!st.isEmpty() && arr[i] < arr[st.peek()]){
                st.pop();
            }
            ans[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        return ans;
    }
}
