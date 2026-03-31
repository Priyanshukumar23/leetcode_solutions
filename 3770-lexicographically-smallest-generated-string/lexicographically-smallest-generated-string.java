import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public String generateString(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        int N = n + m - 1;
        char[] arr = new char[N];
        Arrays.fill(arr, '?');

        // Pass 1: Apply all mandatory 'T' constraints
        for (int i = 0; i < n; i++) {
            if (str1.charAt(i) == 'T') {
                for (int j = 0; j < m; j++) {
                    if (arr[i + j] != '?' && arr[i + j] != str2.charAt(j)) {
                        return ""; // Conflict detected
                    }
                    arr[i + j] = str2.charAt(j);
                }
            }
        }

        // Precompute the last '?' index for each 'F' window
        int[] lastQ = new int[n];
        Arrays.fill(lastQ, -1);
        for (int i = 0; i < n; i++) {
            if (str1.charAt(i) == 'F') {
                for (int j = m - 1; j >= 0; j--) {
                    if (arr[i + j] == '?') {
                        lastQ[i] = i + j;
                        break;
                    }
                }
                
                // If there are no '?' in this 'F' window, it's fully fixed. Check if it illegally matches str2.
                if (lastQ[i] == -1) {
                    boolean match = true;
                    for (int j = 0; j < m; j++) {
                        if (arr[i + j] != str2.charAt(j)) {
                            match = false;
                            break;
                        }
                    }
                    if (match) return ""; 
                }
            }
        }

        // Group 'F' windows by their last '?' index to process them optimally
        List<Integer>[] triggers = new ArrayList[N];
        for (int i = 0; i < n; i++) {
            if (lastQ[i] != -1) {
                if (triggers[lastQ[i]] == null) {
                    triggers[lastQ[i]] = new ArrayList<>();
                }
                triggers[lastQ[i]].add(i);
            }
        }

        // Pass 2: Greedily assign remaining '?' from left to right
        for (int k = 0; k < N; k++) {
            if (arr[k] == '?') {
                boolean[] forbidden = new boolean[26];
                
                // If this index is the absolute last chance to break a match for any 'F' windows
                if (triggers[k] != null) {
                    for (int i : triggers[k]) {
                        boolean match = true;
                        // Check if the rest of this specific window already matches str2
                        for (int j = 0; j < m; j++) {
                            if (i + j == k) continue; 
                            if (arr[i + j] != str2.charAt(j)) {
                                match = false;
                                break;
                            }
                        }
                        // If everything else matches, we MUST NOT pick the character that completes it
                        if (match) {
                            forbidden[str2.charAt(k - i) - 'a'] = true;
                        }
                    }
                }

                // Pick the lexicographically smallest allowed character
                char chosen = '?';
                for (int c = 0; c < 26; c++) {
                    if (!forbidden[c]) {
                        chosen = (char) ('a' + c);
                        break;
                    }
                }
                
                if (chosen == '?') return ""; // All 26 characters are forbidden (Fallback)
                arr[k] = chosen;
            }
        }

        // Final safety validation to ensure no 'F' constraints were accidentally violated
        for (int i = 0; i < n; i++) {
            if (str1.charAt(i) == 'F') {
                boolean match = true;
                for (int j = 0; j < m; j++) {
                    if (arr[i + j] != str2.charAt(j)) {
                        match = false;
                        break;
                    }
                }
                if (match) return "";
            }
        }

        return new String(arr);
    }
}