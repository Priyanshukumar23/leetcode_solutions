class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int max=0,s=0;
        int n = cardPoints.length;
        for(int i=0;i<k;i++){
            s += cardPoints[i];
        }
        max = s;
        int r = n-1;
        for(int i=k-1;i>=0;i--){
            s -= cardPoints[i];
            s += cardPoints[r];
            r--;
            max = Math.max(max,s);
        }
        return max;
    }
}