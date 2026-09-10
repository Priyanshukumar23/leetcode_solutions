class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        int l=0;
        int r = n-1;
        while(l<r){
            int s = numbers[l]+numbers[r];
            if(s==target){
                return new int[]{l+1,r+1};
            }
            if(s<target){
                l++;
            }
            if(s>target){
                r--;
            }
        }
        return new int[]{l,r};
    }
}