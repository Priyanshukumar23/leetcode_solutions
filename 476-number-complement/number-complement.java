class Solution {
    public int findComplement(int n) {
        int r=0;
        int x = n;
        int m = 0;
        while(x>0){
            m = (m<<1)|1;
            x = x>>1;
        }
        return n^m;
    }
}