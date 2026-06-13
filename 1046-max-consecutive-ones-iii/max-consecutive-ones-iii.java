class Solution {
    public int longestOnes(int[] nums, int k) {
        int l=0,max=0,c=0;
        int n = nums.length;
        for(int i=0;i<n;i++){
            if(nums[i]==0)c++;
            if(c>k){
                if(nums[l]==0)c--;
                l++;
            }
            max = Math.max(max,i-l+1);
        }
        return max;
    }
}