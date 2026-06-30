class Solution {
    // public static double recur(double x, long n){
    //     if(n==0)return 1;
    //     x *= recur(x,n-1);
    //     // return x*recur(x,n-1);
    //     return x;

    // }
    public double myPow(double x, int n) {
    //    long N = n;
    //    if(N<0){
    //     x= 1/x;
    //     N = -N;
    //    }
        return Math.pow(x,n);
    }
}