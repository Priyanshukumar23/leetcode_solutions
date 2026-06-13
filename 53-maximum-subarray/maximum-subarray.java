class Solution {
    public int maxSubArray(int[] nums) {
        int l=0,s=nums[0];
        // int max = Integer.MIN_VALUE;
        int sum=nums[0];

        int n = nums.length;
        for(int i=1;i<n;i++){
            sum = Math.max(nums[i],sum+nums[i]);
            s = Math.max(s,sum);
        }
        
        return s;
    }
}