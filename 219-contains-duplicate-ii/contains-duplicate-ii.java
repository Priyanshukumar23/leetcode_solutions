class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer,Integer>mp = new HashMap<>();
        boolean c = false;
        // for(int i=0;i<n;i++){
        //     for(int j=i+1;j<n;j++){
        //         if(nums[i]==nums[j] && Math.abs(i-j)<=k){
        //             c = true;
        //         }
        //     }
        // }
        for(int i=0;i<n;i++){
            if(mp.containsKey(nums[i])){
                if(i-mp.get(nums[i])<=k){
                    c= true;
                }
            }
            mp.put(nums[i],i);
        }
        
        return c;
    }
}