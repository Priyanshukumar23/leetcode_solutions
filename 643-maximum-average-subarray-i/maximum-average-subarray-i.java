class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int n = nums.length;
        double max = Integer.MIN_VALUE;
        double s = 0;
        for(int i=0;i<k;i++){
            s += nums[i];
        }
        max = Math.max(max,s);
        for(int i=k;i<n;i++){
            s = s-nums[i-k]+nums[i];
            max = Math.max(max,s);
        }
        return (double)max/k;
    }
}