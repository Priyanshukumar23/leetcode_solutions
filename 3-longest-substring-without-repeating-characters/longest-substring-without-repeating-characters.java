class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int[] fr = new int[256];
        for(int i=0;i<256;i++){
            fr[i] = -1;
        }
        int l=0,max=0;
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