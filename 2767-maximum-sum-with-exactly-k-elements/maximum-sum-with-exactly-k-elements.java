class Solution {
    public int maximizeSum(int[] nums, int k) {
        int n = nums.length;
        int s=0,max=0;
        for(int nu:nums){
            max = Math.max(max,nu);
        }
        for(int i=0;i<k;i++){
            s += max;
            max++;
        }
        return s;
    }
}