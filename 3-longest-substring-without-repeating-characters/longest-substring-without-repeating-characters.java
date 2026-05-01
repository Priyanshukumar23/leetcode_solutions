class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int[] map = new int[256];
        int l=0,max=0;
        for(int i=0;i<256;i++){
            map[i] = -1;
        }
        for(int i=0;i<n;i++){
            char ch = s.charAt(i);
            if(map[ch]>=l){
                l = map[ch]+1;
            }
            map[ch] = i;
            max = Math.max(max,i-l+1);
        }
        return max;
    }
}