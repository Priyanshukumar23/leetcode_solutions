class Solution {
    public int findMaxLength(int[] nums) {
        int n = nums.length;
        int count = 0;
        int s = 0;
       int max = 0;
       HashMap<Integer,Integer>mp = new HashMap<>();
       mp.put(0,-1);
       for(int i=0;i<n;i++){
        if(nums[i]==0){
            s += -1;
        } else{
            s += 1;
        }
        if(mp.containsKey(s)){
            max = Math.max(max,i-mp.get(s));
        } else{
            mp.put(s,i);
        }
       }
       return max;
    }
}