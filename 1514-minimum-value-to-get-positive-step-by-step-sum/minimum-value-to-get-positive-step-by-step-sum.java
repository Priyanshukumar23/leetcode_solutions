class Solution {
    public int minStartValue(int[] nums) {
        int p = 0,mp=0;
        for(int n:nums){
            p += n;
            mp = Math.min(mp,p);
        }
        return 1-mp;
        
    }
}