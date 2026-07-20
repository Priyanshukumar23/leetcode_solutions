class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>>at = new HashSet<>();
        int n = nums.length;
        Arrays.sort(nums);
        for(int i=0;i<n-2;i++){
            int l = i+1,h=n-1;
            while(l<h){
                int s = nums[i]+nums[l]+nums[h];
                if(s==0){
                    at.add(Arrays.asList(nums[i],nums[l],nums[h]));
                    l++;
                    h--;
                } else if(s<0){
                    l++;
                } else{
                    h--;
                }
            }
        }
        return new ArrayList<>(at);
    }
}