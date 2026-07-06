class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int l=0;
        int s = nums[0];
        int min = Integer.MAX_VALUE;
        int x = 0;
        for(int nu:nums){
            x += nu;
        }
        if(s>=target)return 1;
        if(target>x)return 0;
        for(int i=1;i<n;i++){
            s += nums[i];
            while(s>=target){
                min = Math.min(min,i-l+1);
                s -= nums[l];
                l++;
            }
        }
        return min;
    }
}