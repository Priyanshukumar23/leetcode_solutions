class Solution {
    public double myPow(double x, int n) {
        long N = n;
        if(n<0){
            N = -1*N;
            x = 1/x;
        }
        return pw(x,N);
    }
    private double pw(double x,long N){
        if(N==0)return 1;
       double half = pw(x,N/2);
       if(N%2==0){
        return half*half;
       } else{
        return half*half*x;
       }
    }
}