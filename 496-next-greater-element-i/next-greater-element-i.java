class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        Stack<Integer>st = new Stack<>();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = -1;
        }
        int t = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(nums1[i]==nums2[j]){
                int x=j+1;
                    while(x<m && nums2[j]>=nums2[x]){
                        x++;
                    }
                    if(x<m){
                        arr[i] = nums2[x];
                    }
                    
                }
            }
        }
        return arr;

    }
}