class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer>st = new HashSet<>();
        while(n!=1 && !st.contains(n)){
            st.add(n);
            int s = 0;
            while(n>0){
                int d = n%10;
                s += d*d;
                n = n/10;
            }
            n = s;
        }
        return n==1;
    }
}