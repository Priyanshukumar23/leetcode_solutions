class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        LinkedHashSet<Integer>st = new LinkedHashSet<>();
        for(int nu:nums){
            st.add(nu);
        }
        int v=0;
        for(int x:st){
            nums[v++] = x;
        }
        //Arrays.sort(nums);
        return v;
    }
}