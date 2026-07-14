class Solution {
    public int diagonalSum(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int s = 0;
        for(int i=0;i<n;i++){
            s += mat[i][i];
            s += mat[i][n-i-1];
        }
        if(n%2==1){
            s -= mat[n/2][n/2];
        }
        return s;
    }
}