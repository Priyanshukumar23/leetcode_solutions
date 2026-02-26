class Solution {
    public int numSteps(String s) {
        int n = s.length();
        int steps = 0;
        int carry = 0;
        
        // Traverse from right to left (ignore first bit)
        for(int i = n - 1; i > 0; i--) {
            
            int bit = s.charAt(i) - '0';
            int sum = bit + carry;
            
            // If even
            if(sum % 2 == 0) {
                steps += 1;  // divide by 2
            } 
            // If odd
            else {
                steps += 2;  // add 1 + divide by 2
                carry = 1;   // adding 1 creates carry
            }
        }
        
        // If carry remains at MSB
        return steps + carry;
    }
}