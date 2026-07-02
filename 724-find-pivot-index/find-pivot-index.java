class Solution {
    public int pivotIndex(int[] nums) {
        int s = 0;
        int n = nums.length;
        int p = 0;
        int r = n-1;
        for(int i=0;i<n;i++){
            s += nums[i];
        }
        for(int i=0;i<n;i++){
            s -= nums[i];
            
            if(s==p){
                return i;
            }
            p += nums[i];
        }
        return -1;
    }
}