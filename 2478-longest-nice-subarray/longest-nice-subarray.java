class Solution {
    public int longestNiceSubarray(int[] nums) {
        int n = nums.length;
        int l=0,max=0,bits=0;
        for(int i=0;i<n;i++){
            while((bits & nums[i])!=0){
                bits ^= nums[l];
                l++;
            }
            bits |= nums[i];
            max = Math.max(max,i-l+1);
        }
        return max;
    }
}