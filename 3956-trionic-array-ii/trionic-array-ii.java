class Solution {
    public long maxSumTrionic(int[] nums) {
        // Initialize states to a value representing "invalid".
        // We use Long.MIN_VALUE / 2 to avoid overflow when adding nums[i].
        long up1 = Long.MIN_VALUE / 2;
        long down = Long.MIN_VALUE / 2;
        long up2 = Long.MIN_VALUE / 2;
        
        long maxTrionicSum = Long.MIN_VALUE;

        for (int i = 1; i < nums.length; i++) {
            long val = nums[i];
            long prevVal = nums[i - 1];
            
            // Temporary variables for the current step
            long curUp1 = Long.MIN_VALUE / 2;
            long curDown = Long.MIN_VALUE / 2;
            long curUp2 = Long.MIN_VALUE / 2;

            if (val > prevVal) {
                // --- STRICTLY INCREASING STEP ---
                
                // 1. Update First Up Phase (up1)
                // We can extend a previous up1 OR start a new one using [prevVal, val]
                // If up1 was invalid, max takes prevVal, effectively starting a new sequence.
                curUp1 = Math.max(up1, prevVal) + val;
                
                // 2. Update Second Up Phase (up2)
                // We can extend a previous up2 OR transition from a Down phase.
                // Transition happens if we turn from Down (at i-1) to Up (at i).
                curUp2 = Math.max(up2, down) + val;
                
                // Note: We cannot be in the Down phase if we just increased.
                // curDown remains invalid.

            } else if (val < prevVal) {
                // --- STRICTLY DECREASING STEP ---
                
                // 1. Update Down Phase (down)
                // We can extend a previous down OR transition from up1.
                // Transition happens if we turn from Up1 (at i-1) to Down (at i).
                curDown = Math.max(down, up1) + val;
                
                // Note: We cannot be in an Up phase (up1 or up2) if we just decreased.
                // curUp1 and curUp2 remain invalid.
                
            } 
            // If val == prevVal, strict monotonicity is broken. 
            // All states reset to invalid (handled by initialization of cur variables).

            // Update state variables for the next iteration
            up1 = curUp1;
            down = curDown;
            up2 = curUp2;

            // Update the global maximum with the best valid trionic sum found so far
            if (up2 > maxTrionicSum) {
                maxTrionicSum = up2;
            }
        }

        return maxTrionicSum;
    }
}