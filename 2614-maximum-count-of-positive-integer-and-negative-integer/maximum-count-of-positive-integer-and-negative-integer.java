class Solution {
    public int maximumCount(int[] nums) {
        int c = 0;
        int r = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                continue;
            }
            if(nums[i]<0)c++;
            else r++;
        }
        return Math.max(c,r);
    }
}