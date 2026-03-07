class Solution {
    public int minFlips(String s) {

        int n = s.length();
        s = s + s;

        int diff1 = 0;
        int diff2 = 0;
        int res = Integer.MAX_VALUE;

        int l = 0;

        for (int r = 0; r < s.length(); r++) {

            char expected1 = (r % 2 == 0) ? '0' : '1';
            char expected2 = (r % 2 == 0) ? '1' : '0';

            if (s.charAt(r) != expected1) diff1++;
            if (s.charAt(r) != expected2) diff2++;

            if (r - l + 1 > n) {

                char leftExpected1 = (l % 2 == 0) ? '0' : '1';
                char leftExpected2 = (l % 2 == 0) ? '1' : '0';

                if (s.charAt(l) != leftExpected1) diff1--;
                if (s.charAt(l) != leftExpected2) diff2--;

                l++;
            }

            if (r - l + 1 == n) {
                res = Math.min(res, Math.min(diff1, diff2));
            }
        }

        return res;
    }
}