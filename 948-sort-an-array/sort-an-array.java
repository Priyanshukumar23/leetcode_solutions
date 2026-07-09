class Solution {
    public int[] sortArray(int[] arr) {
        int n = arr.length;
       mergesort(arr,0,n-1);
       return arr;
    }
    public void mergesort(int[] arr,int l,int r){
        if(l>=r)return;
        int m = l+(r-l)/2;
        mergesort(arr,l,m);
        mergesort(arr,m+1,r);
        merge(arr,l,m,r);
    }
    private void merge(int[] arr,int l,int m,int r){
        int[] t = new int[r-l+1];
        int i=l;
        int j = m+1;
        int k=0;
        while(i<=m && j<=r){
            if(arr[i]<=arr[j]){
                t[k++] = arr[i++];
            } else{
                t[k++] = arr[j++];
            }
        }
        while(i<=m){
            t[k++] = arr[i++];
        }
        while(j<=r){
            t[k++] = arr[j++];
        }
        for(int x=0;x<k;x++){
            arr[l+x] = t[x];
        }
    }
}