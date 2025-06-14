class Solution {
    public long subArrayRanges(int[] nums) {
        long minSum = sumMin(nums);
        long maxSum = sumMax(nums);
        return maxSum-minSum;
    }
    public int[] psee (int[] nums){
        int n = nums.length;
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[n];
        for(int i=0; i<n; i++){
            while(!st.isEmpty() && nums[st.peek()] > nums[i]){
                st.pop();
            }
            ans[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        return ans;
    }

    public int[] nse(int[] nums){
        int n = nums.length;
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[n];
        for(int i=n-1; i>=0; i--){
            while(!st.isEmpty() && nums[st.peek()] >= nums[i]){
                st.pop();
            }
            ans[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        return ans;
    }
    public int[] pgee(int[] nums){
        int n = nums.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<n; i++){
            while(!st.isEmpty() && nums[st.peek()] < nums[i]){
                st.pop();
            }
            ans[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        return ans;
    }
    public int[] nge(int[] nums){
        int n = nums.length;
        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i=n-1; i>=0; i--){
            while(!st.isEmpty() && nums[st.peek()] <= nums[i]){
                st.pop();
            }
            ans[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        return ans;

    }

    public long sumMin(int[] nums){
        int n = nums.length;
        long sum = 0;
        int[] pse = psee(nums);
        int[] nse = nse(nums);
        for(int i=0; i<n; i++){
            long l = i-pse[i];
            long r = nse[i]-i;
            long total = (l*r)*nums[i];
            sum += total;
        } 
        return sum;
    }

    public long sumMax(int[] nums){
        int n = nums.length;
        int[] pge = pgee(nums);
        int[] nge = nge(nums);
        long sum = 0;
        for(int i=0; i<n; i++){
            long l = i-pge[i];
            long r = nge[i]-i;
            long total = l*r*nums[i];
            sum += total;
        }
        return sum;
    }

}
