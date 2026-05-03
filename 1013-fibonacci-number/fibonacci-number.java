class Solution {
    public int fib(int n) {
        // if(n==0)return 0;
        // if(n==1)return 1;
        // int l = fib(n-1);
        // int r = fib(n-2);
        // return l+r;
        if(n<1)return 0;
        int p = 0;
        int q = 1;
        for(int i=2;i<=n;i++){
            int c = p+q;
            p = q;
            q = c;
        }
        return q;
    }
}