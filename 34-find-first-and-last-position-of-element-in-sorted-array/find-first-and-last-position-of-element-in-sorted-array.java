class Solution {
    public int[] searchRange(int[] nums, int target) {
        int n = nums.length;
        int l = 0, r = n-1;
        
        int ans = -1,x = -1;
        while(l<=r){
            int mid = l+(r-l)/2;
            if(nums[mid]==target){
                ans = mid;
                r = mid-1;
            } else if(nums[mid]<target){
                l = mid+1;
            } else{
                r = mid-1;
            }
        }

        l = 0;
        r = n-1;
        while(l<=r){
            int mid = l+(r-l)/2;
            if(nums[mid]==target){
                x = mid;
                l = mid+1;
            } else if(nums[mid]<target){
                l = mid+1;
            } else{
                r = mid-1;
            }
        }
        return new int[]{ans,x};
    }
}