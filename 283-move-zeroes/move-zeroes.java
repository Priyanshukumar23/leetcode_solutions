class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int x = 0;
        for(int i=0;i<n;i++){
            if(nums[i]!=0){
                nums[x++] = nums[i];
            }
        }
        for(int i=x;i<n;i++){
            nums[i]=0;
        }
        
    }
}