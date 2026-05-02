class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int n = nums.length;
        int l=0,max=0;
        for(int i=0;i<n;i++){
            while(nums[i]==0){
                nums[l]--;
                l++;
            }
            max = Math.max(max,i-l+1);
        }
        return max;
    }
}