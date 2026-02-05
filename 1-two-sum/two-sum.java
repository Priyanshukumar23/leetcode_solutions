class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        HashMap<Integer,Integer>mp = new HashMap<>();
        int s = 0;
        int c=0;
        for(int i=0;i<n;i++){
            s = target-nums[i];
            if(mp.containsKey(s)){
                return new int[]{mp.get(s),i};
            }
            mp.put(nums[i],i);
        }
        // for(int i=0;i<n;i++){
        //     for(int j=i+1;j<n;j++){
        //         if(nums[i]+nums[j]==target){
        //             return new int[]{i,j};
        //         }
        //     }
        // }
        // return new int[]{};
        return new int[]{};
    }
}