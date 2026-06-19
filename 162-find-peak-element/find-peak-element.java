class Solution {
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        int l=0,h=n-1;
        
        while(l<h){
            int mid = l+(h-l)/2;
            if(nums[mid+1]>nums[mid]){
                l = mid+1;
            } else{
                h = mid;
                
            }
        }
        return l;
    }
}