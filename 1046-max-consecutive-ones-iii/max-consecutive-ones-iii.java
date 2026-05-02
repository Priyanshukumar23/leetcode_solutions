class Solution {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int l=0,max=0,x=0;
        for(int i=0;i<n;i++){
            if(nums[i]==0)l++;
            if(l>k){
                if(nums[x]==0)l--;
                x++;
            }
            max = Math.max(max,i-x+1);
        }
        return max;
    }
}