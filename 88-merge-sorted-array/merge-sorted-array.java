class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int x = n+m;
        int[] arr = new int[x];
        for(int i=0;i<m;i++){
            arr[i] = nums1[i];
        }
        for(int i=0;i<n;i++){
            arr[i+m] = nums2[i];
        }
        for(int i=0;i<x;i++){
            nums1[i] = arr[i];
        }
        Arrays.sort(nums1);
    }
}