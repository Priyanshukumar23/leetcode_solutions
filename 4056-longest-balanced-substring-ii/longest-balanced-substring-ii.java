import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;

class Solution {
    public int longestBalanced(String s) {
        if (s == null || s.length() == 0) return 0;
        
        int n = s.length();
        int maxLen = 0;

        // 1. Single distinct character (e.g., "aaa")
        // Standard linear scan
        int currentRun = 0;
        for (int i = 0; i < n; i++) {
            if (i > 0 && s.charAt(i) == s.charAt(i - 1)) {
                currentRun++;
            } else {
                currentRun = 1;
            }
            maxLen = Math.max(maxLen, currentRun);
        }

        // 2. Two distinct characters (e.g., "abba")
        // We optimize this using primitive arrays instead of HashMaps.
        // We reuse the same arrays for all 3 calls to save allocation time.
        // Size is 2*n + 1 to handle balances from -n to +n.
        int[] firstOccurrence = new int[2 * n + 1];
        int[] runIds = new int[2 * n + 1];
        // Initialize runIds with -1 so 0 is a valid ID
        Arrays.fill(runIds, -1); 
        
        maxLen = Math.max(maxLen, solvePairOptimized(s, 'a', 'b', 'c', firstOccurrence, runIds));
        maxLen = Math.max(maxLen, solvePairOptimized(s, 'a', 'c', 'b', firstOccurrence, runIds));
        maxLen = Math.max(maxLen, solvePairOptimized(s, 'b', 'c', 'a', firstOccurrence, runIds));

        // 3. Three distinct characters (e.g., "abc")
        // Checks for count(a) == count(b) == count(c)
        maxLen = Math.max(maxLen, solveTriplet(s));

        return maxLen;
    }

    private int solvePairOptimized(String s, char c1, char c2, char forbidden, int[] firstOccurrence, int[] runIds) {
        int max = 0;
        int n = s.length();
        int balance = 0; // Represents count(c1) - count(c2)
        int currentRunId = 0; // Tracks separate segments broken by forbidden chars
        
        // We generate a unique run ID for this specific function call to avoid dirty reads 
        // from previous solvePairOptimized calls without re-filling the array.
        // However, since we pass 'runIds' in, we need a way to ensure uniqueness.
        // Simpler approach: Increment a local run counter, but that requires resetting arrays between function calls.
        // To avoid Arrays.fill every time, we can just assume the arrays are reusable if we manage IDs correctly.
        // Actually, simplest is to just increment a 'global' ID passed in, or just clear runIds once per function call.
        // Given N=10^5, Arrays.fill is very fast (native memset). Let's just fill runIds with -1 at start of each call.
        
        Arrays.fill(runIds, -1);
        int offset = n; // Offset to handle negative indices
        
        // Initial state: balance 0 seen at index -1
        runIds[0 + offset] = 0;
        firstOccurrence[0 + offset] = -1;

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == forbidden) {
                // Start a new logical run. 
                // We increment the ID so previous entries in the array are ignored.
                currentRunId++;
                balance = 0;
                
                // Reset initial state for the new run
                runIds[0 + offset] = currentRunId;
                firstOccurrence[0 + offset] = i;
            } else {
                if (c == c1) balance++;
                else if (c == c2) balance--;
                
                int index = balance + offset;
                
                if (runIds[index] == currentRunId) {
                    // We saw this balance in the current valid segment
                    max = Math.max(max, i - firstOccurrence[index]);
                } else {
                    // First time seeing this balance in this segment
                    runIds[index] = currentRunId;
                    firstOccurrence[index] = i;
                }
            }
        }
        return max;
    }

    private int solveTriplet(String s) {
        int max = 0;
        int a = 0, b = 0, c = 0;
        
        // Key: Encoded difference (a-b, b-c). Value: First index seen.
        Map<Long, Integer> map = new HashMap<>();
        
        long n = s.length();
        long base = 2 * n + 2; 
        
        long initialKey = (0 + n) * base + (0 + n);
        map.put(initialKey, -1);

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == 'a') a++;
            else if (ch == 'b') b++;
            else if (ch == 'c') c++;

            long diff1 = a - b;
            long diff2 = b - c;
            
            long key = (diff1 + n) * base + (diff2 + n);
            
            // Using get/put reduces lookups compared to containsKey + get
            Integer prevIndex = map.get(key);
            if (prevIndex != null) {
                max = Math.max(max, i - prevIndex);
            } else {
                map.put(key, i);
            }
        }
        return max;
    }
}