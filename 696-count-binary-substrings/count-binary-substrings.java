class Solution {
    public int countBinarySubstrings(String s) {
        int prev = 0;      // previous group length
        int curr = 1;      // current group length
        int count = 0;     // result
        
        for (int i = 1; i < s.length(); i++) {
            
            if (s.charAt(i) == s.charAt(i - 1)) {
                curr++;    // same group continues
            } else {
                count += Math.min(prev, curr);
                prev = curr;
                curr = 1;  // reset for new group
            }
        }
        
        count += Math.min(prev, curr);
        
        return count;
    }
}
