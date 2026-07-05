class Solution {
    public int maxProfit(int[] arr) {
        int n = arr.length;
        int min = Integer.MAX_VALUE;
        int max = 0;
        for(int i=0;i<n-1;i++){
            min = Math.min(min,arr[i]);
            max = Math.max(max,arr[i+1]-min);
        }
        return max;
    }
}