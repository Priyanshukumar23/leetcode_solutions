class Solution {
    public void moveZeroes(int[] nums) {
        int n = nums.length;
        // int[] arr = new int[n];
        // int c=0;
        // for(int i=0;i<n;i++){
        //     if(nums[i]!=0){
        //         arr[c++] = nums[i];
                
        //     }
            
        // }
        
        // for(int i=0;i<n;i++){
        //     nums[i] = arr[i];
        // }
        int j=0;
        for(int i=0;i<n;i++){
            if(nums[i]!=0){
                int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            j++;
            }
            
        }
        for(int i=0;i<n;i++){
            System.out.print(nums[i]+" ");
        }
    }
}