class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        int r = n-1;
        int s=0,x=0;
        int l = 0;
        int[] arr = new int[2];
        while(l<r){
            s = numbers[l]+numbers[r];
            if(s>target){
                r--; 
            }
            if(s<target){
                l++;
            }
            if(s==target){
                return new int[]{l+1,r+1};
            }
        }
        return new int[]{l,r};
    }
}