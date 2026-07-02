class Solution {
    public int largestAltitude(int[] gain) {
        int n = gain.length;
        int[] arr = new int[n+1];
        int l=0;
        arr[0] = gain[0];
        for(int i=1;i<n;i++){
            arr[i] = arr[i-1]+gain[i];
        }
        Arrays.sort(arr);
        int x = arr[n];
        return x;
    }
}