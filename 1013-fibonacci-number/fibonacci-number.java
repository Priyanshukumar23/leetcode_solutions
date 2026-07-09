class Solution {
    public int fib(int n) {
        return fs(n);
    }
    private int fs(int n){
        if(n==0)return 0;
        if(n==1)return 1;
        return fs(n-1)+fs(n-2);
    }
}