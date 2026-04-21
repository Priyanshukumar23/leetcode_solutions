class Solution {
    public int subarraySum(int[] nums, int k) {
        int s = 0,c = 0;
        HashMap<Integer,Integer>mp = new HashMap<>();
        mp.put(0,1);
        for(int i=0;i<nums.length;i++){
            s += nums[i];
            if(mp.containsKey(s-k)){
                c += mp.get(s-k);
            }
            mp.put(s,mp.getOrDefault(s,0)+1);
        }
        return c;
    }
}