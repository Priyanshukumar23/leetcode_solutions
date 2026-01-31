class Solution {
    public char nextGreatestLetter(char[] letters, char target) {

        int left = 0;
        int right = letters.length - 1;
        char ans = letters[0]; // default wrap-around answer

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (letters[mid] > target) {
                ans = letters[mid];   // possible answer
                right = mid - 1;      // try smaller index
            } else {
                left = mid + 1;
            }
        }

        return ans;
    }
}
