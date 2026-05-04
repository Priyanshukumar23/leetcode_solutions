class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int p = nums[0];
        int p2 = 0;
        for(int i=1;i<n;i++){
            int t = nums[i];
            if(i>1) t += p2;
            int nt = 0+p;
            int curr = Math.max(t,nt);
            p2 = p;
            p = curr;
        }
        return p;
        
    }
}