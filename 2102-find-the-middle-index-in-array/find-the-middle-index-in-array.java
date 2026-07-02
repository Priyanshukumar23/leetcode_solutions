class Solution {
    public int findMiddleIndex(int[] nums) {
        int n = nums.length;
        int p = 0,s=0;
        for(int i=0;i<n;i++){
            s += nums[i];
        }
        for(int i=0;i<n;i++){
            s -= nums[i];
            if(p==s){
                return i;
            }
            p += nums[i];
        }
        return -1;
    }
}