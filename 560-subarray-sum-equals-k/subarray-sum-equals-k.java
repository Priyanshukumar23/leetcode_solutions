class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int prefix[] = new int[n];
        prefix[0] = nums[0];
        int c=0;
        HashMap<Integer,Integer>mp = new HashMap<>();
        mp.put(0,1);
        int s = 0;
        for(int arr:nums){
            s += arr;
            if(mp.containsKey(s-k)){
                c+= mp.getOrDefault(s-k,0);
            }
            mp.put(s,mp.getOrDefault(s,0)+1);
        }
        return c;
    }
}