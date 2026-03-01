class Solution {
    public int minPartitions(String n) {
        int maxDigit = 0;
        
        for (int i = 0; i < n.length(); i++) {
            int digit = n.charAt(i) - '0';
            maxDigit = Math.max(maxDigit, digit);
            
            // Optimization: if we ever find 9, return immediately
            if (maxDigit == 9) return 9;
        }
        
        return maxDigit;
    }
}