class Solution {
    public int longestContinuousSubstring(String s) {
        int n = s.length();
        int max = 1,cur = 1;
        for(int i=1;i<n;i++){
            char ch = s.charAt(i);
            if(s.charAt(i)==s.charAt(i-1)+1){
                cur++;
            } else{
                cur = 1;
            }
            max = Math.max(cur,max);
        }
        return max;
    }
}