class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int n = arr.length;
       
        int s=0,c=0;
        
        for(int i=0;i<k;i++){
            s += arr[i];
        }
        int avg = 0;
        avg = s/k;
        if(avg>=threshold){
            c++;
        }
        for(int i=k;i<n;i++){
            s = s+arr[i]-arr[i-k];
            avg = s/k;
            if(avg>=threshold){
                c++;
            }
        }
        return c;
    }
}