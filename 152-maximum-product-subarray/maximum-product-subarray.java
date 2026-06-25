class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int p = nums[0];
        int min = nums[0];
        int max = nums[0];
        for(int i=1;i<n;i++){
            if(nums[i]<0){
                int t = p;
                p = min;
                min = t;
            }
            min = Math.min(nums[i],min*nums[i]);
            p = Math.max(nums[i],p*nums[i]);
            max = Math.max(p,max);
        }
        return max;
    }
}