class Solution {
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        Arrays.sort(nums);
        // int[] arr = new int[n];
        // for(int i=n-1;i>=0;i--){
        //     arr[i] = nums[i];
        // }
        return nums[n-k];
    }
}