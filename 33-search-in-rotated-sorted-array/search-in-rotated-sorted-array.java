class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int l = 0, r = n-1;
        int x = 0;
        for(int i=0;i<n;i++){
            if(nums[i]==target)return i;
        }
        return -1;
    }
}