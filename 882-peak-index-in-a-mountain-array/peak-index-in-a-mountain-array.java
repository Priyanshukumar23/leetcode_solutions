class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int n = arr.length;
        int s=0;
        for(int i=0;i<n-1;i++){
            if(arr[i]<arr[i+1]){
                s = i;
            }
        }
        return s+1;
    }
}