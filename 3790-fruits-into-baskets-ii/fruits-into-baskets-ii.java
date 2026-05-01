class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int n = fruits.length;
        int m = baskets.length;
        int c=0;
        boolean[] vis = new boolean[m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!vis[j] && (fruits[i]<=baskets[j])){
                    vis[j] = true;
                    c++;
                    break;
                }
            }
        }
        return n-c;
    }
}