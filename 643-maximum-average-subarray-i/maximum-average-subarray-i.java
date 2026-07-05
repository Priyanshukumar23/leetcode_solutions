class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer,Integer>mp = new HashMap<>();
        for(int i=0;i<n;i++){
            mp.put(nums[i],mp.getOrDefault(nums[i],0)+1);
        }
        double max=Integer.MIN_VALUE;
        int l = 0,s=0;
        for(int i=0;i<k;i++){
            s += nums[i];
        }
        max = Math.max(max,s);
        for(int i=k;i<n;i++){
            s = nums[i]+s-nums[l];
            l++;
            max = Math.max(max,s);
        }
        return (double)max/k;
    }
}