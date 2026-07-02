class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n];
        HashMap<Integer,Integer>mp = new HashMap<>();
        int s = 1,m=1;
        for(int nu:nums){
            mp.put(nu,mp.getOrDefault(nu,0)+1);
        }
        for(int i=0;i<n;i++){
            s = s*nums[i];
            
            if(nums[i]!=0){
                m = m*nums[i];
            }
        }
        for(int i=0;i<n;i++){
            if(mp.containsKey(0) && mp.get(0)>1){
                arr[i] = 0;
            } else{
                if(nums[i]==0){
                    arr[i] = m;
                } else{

                arr[i] = s/nums[i];
                }
            }
            
            
        }
        return arr;
    }
}