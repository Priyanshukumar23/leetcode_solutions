class Solution {
    public int fib(int n) {
        if(n==0)return 0;
        if(n==1)return 1;
        int l = fib(n-1);
        int r = fib(n-2);
        return l+r;
    }
}