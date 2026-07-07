class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n];
        int c = 0,x=0;
        for(int i=0;i<n;i++){
            if(nums[i]!=0){
                arr[x++] = nums[i];
                c++;
            }
        }
        for(int i=c;i<n;i++){
            arr[i] = 0;
        }
        for(int i=0;i<n;i++){
            nums[i] = arr[i];
        }
        
    }
}