class Solution {
    public int countSymmetricIntegers(int low, int high) {
        int count = 0;
        for(int i=low; i<=high; i++){
            String s = String.valueOf(i);
            if((s.length()%2 == 0 ) && sum(s)){
                count++;
            }
        }
        return count;
    }
    public boolean sum(String s){
        int n = s.length();
        int suml = 0;
        int sumr = 0;
        for(int i=0; i<n/2; i++){
            suml += s.charAt(i) - '0';
        }
        for(int i=n/2; i<n; i++){
            sumr += s.charAt(i) - '0';
        }
        return suml == sumr;
    }
}
