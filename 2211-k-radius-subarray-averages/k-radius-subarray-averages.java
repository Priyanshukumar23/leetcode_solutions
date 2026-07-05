class Solution {
    public int[] getAverages(int[] nums, int k) {
        int n = nums.length;
        int ws = 2*k+1;
        int[] arr = new int[n];
        
        for(int i=0;i<n;i++){
            arr[i] = -1;
        }
        if(ws>n)return arr;
        long s = 0;
        int l=0;
        int avg = 0;
        for(int i=0;i<ws;i++){
            s += nums[i];
        }
        arr[k] = (int)(s/ws);
        for(int i=ws;i<n;i++){
            s -= nums[l];
            l++;
            s += nums[i];
            arr[k+l] = (int)(s/ws);
        }
        return arr;
    }
}