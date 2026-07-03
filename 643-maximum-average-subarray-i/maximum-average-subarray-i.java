class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int n = nums.length;
        double max = Integer.MIN_VALUE;
        
        int l=0;
        double avg = 0;
        double s = 0;
        for(int i=0;i<k;i++){
            s += nums[i];
        }
        avg = s/k;
        max = Math.max(max,avg);
        for(int i=k;i<n;i++){
            s = s-nums[i-k]+nums[i];
            avg = s/k;
            max = Math.max(max,avg);
        }
        return max;
    }
}