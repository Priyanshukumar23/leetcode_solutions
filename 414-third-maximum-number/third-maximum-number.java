class Solution {
    public int thirdMax(int[] nums) {
        int n = nums.length;
        int k=0;
        int max=Integer.MIN_VALUE;
        HashSet<Integer>pq = new HashSet<>();
        for(int i=0;i<n;i++){
            max = Math.max(nums[i],max);
            pq.add(nums[i]);
            
        }
        ArrayList<Integer>at = new ArrayList<>(pq);
        Collections.sort(at);
        if(at.size()<3)return max;
        return at.get(at.size()-3);
    }
}