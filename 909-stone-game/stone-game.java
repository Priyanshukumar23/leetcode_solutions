class Solution {
    public boolean stoneGame(int[] arr) {
        int n = arr.length;
        int sa=0,sb=0;
        int max = 0,min=0;
        int l = n-1;
        for(int i=0;i<=n/2;i++){
            max = Math.max(arr[i],arr[l]);
            min = Math.min(arr[i],arr[l]);
            l--;
            sa += max;
            sb += min;
        }
        return (sa>sb)?true:false;
    }
}