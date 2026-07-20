class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int n = nums.length;
        int c=0,l=0,max=0;
        for(int i=0;i<n;i++){
            if(nums[i]==1){
                c++;
            } else{
                c = 0;
            }
            max = Math.max(c,max);
        }
        return max;
    }
}