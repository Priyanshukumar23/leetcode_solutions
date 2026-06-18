class Solution {
    public int countElements(int[] nums) {
        int n = nums.length;
        int c = 0;
        int max = nums[0];
        int min = nums[0];
        for(int i=0;i<n;i++){
            if(nums[i]>max){
                max = nums[i];
            }
            if(nums[i]<min){
                min = nums[i];
            }
        }
        for(int i=0;i<n;i++){
            if(nums[i]<max && nums[i]>min)c++;
        }
        return c;
    }
}