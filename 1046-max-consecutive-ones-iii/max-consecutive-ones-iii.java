class Solution {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int cz=0,c=0,l=0,max=0;
        for(int i=0;i<n;i++){
            if(nums[i]==0){
                cz++;
            }
            while(cz>k){
                if(nums[l]==0)cz--;
                l++;
            }
            max = Math.max(max,i-l+1);
        }
        return max;
    }
}