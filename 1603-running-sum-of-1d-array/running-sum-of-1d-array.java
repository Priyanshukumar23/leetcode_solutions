class Solution {
    public int[] runningSum(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n];
        int l=0,r = n-1;
        int s = 0;
        arr[0] = nums[0];
        for(int i=1;i<n;i++){
            s = arr[l]+nums[i];
            l++;
            // arr[i] = arr[i-1]+nums[i];
            arr[i] = s;
        }
        return arr;
    }
}