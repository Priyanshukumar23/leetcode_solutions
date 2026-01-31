class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int n = nums.length;
       HashMap<Integer,Integer>mp = new HashMap<>();
       mp.put(0,1);
       int prefix = 0;
       int c=0;
       for(int ch:nums){
        prefix += ch;
        int rem = ((prefix%k)+k)%k;
        if(mp.containsKey(rem)){
            c += mp.get(rem);
        }
        mp.put(rem,mp.getOrDefault(rem,0)+1);
       }
       return c;
    }
}