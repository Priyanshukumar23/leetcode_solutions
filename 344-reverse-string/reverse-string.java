class Solution {
    public void reverseString(char[] s) {
        int n = s.length-1;
        int i=0;
        while(i<n){
            char t = s[n];
            s[n] = s[i];
            s[i] = t;
            i++;
            n--;
        }
    }
}