class Solution {
    public static int atmost(int[] nums,int k){
        int n = nums.length;
        HashMap<Integer,Integer>mp = new HashMap<>();
        int max = 0,l=0;
        
        for(int i=0;i<n;i++){
            mp.put(nums[i],mp.getOrDefault(nums[i],0)+1);
            
            while(mp.size()>k){
                mp.put(nums[l],mp.get(nums[l])-1);
                if(mp.get(nums[l])==0){
                    mp.remove(nums[l]);
                }
                l++;
            }
            max += i-l+1;
        }
        return max;
    }
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atmost(nums,k)-atmost(nums,k-1);
        
        
    }
}