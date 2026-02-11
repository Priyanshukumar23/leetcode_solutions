class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int n = arr.length;
        int l=0;
        int h = n-1;
        int id = -1;
        while(l<=h){
            int mid = l+(h-l)/2;
            if(arr[mid+1]>arr[mid])l = mid+1;
            else if(arr[mid-1]>arr[mid])h = mid-1;
            else{
                id = mid;
                h = mid-1;
            }
                
        }
        return id;
    }
}