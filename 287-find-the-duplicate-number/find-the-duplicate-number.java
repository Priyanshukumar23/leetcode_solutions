class Solution {
    public int findDuplicate(int[] nums) {
        int n = nums.length;
        // HashMap<Integer,Integer>mp = new HashMap<>();
        // for(int i=0;i<n;i++){
        //     mp.put(nums[i],mp.getOrDefault(nums[i],0)+1);
        // }
        // for(int i=0;i<n;i++){
        //     if(mp.get(nums[i])>1)return nums[i];
        // }
        // return -1;
        int slow = nums[0];
        int fast = nums[0];
        do{
            slow = nums[slow];
            fast = nums[nums[fast]];
        }while(slow!=fast);
        slow = nums[0];
        while(slow!=fast){
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}