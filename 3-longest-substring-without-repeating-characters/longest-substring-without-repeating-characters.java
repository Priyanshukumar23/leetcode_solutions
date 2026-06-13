class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] fr = new int[256];
        int n = s.length();
        int max = 0,l=0;
        for(int i=0;i<fr.length;i++){
            fr[i] = -1;
        }
        for(int i=0;i<n;i++){
            char ch = s.charAt(i);
            
            if(fr[ch]>=l){
                l = fr[ch]+1;
               
            }
            fr[ch] = i;
            max = Math.max(max,i-l+1);
        }
        return max;
    }
}