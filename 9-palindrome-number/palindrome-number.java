class Solution {
    public boolean isPalindrome(int x) {
        int r = 0;
        int n = x;
        while(x>0){
            int div = x%10;
            r = r*10+div;
            x = x/10;
        }
        if(n!=r)return false;
        
        return true;
    }
}