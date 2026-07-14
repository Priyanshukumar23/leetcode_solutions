class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        Stack<Integer>st = new Stack<>();
        HashMap<Integer,Integer>mp = new HashMap<>();
        int[] arr = new int[n];
        // for(int i=0;i<n;i++){
        //     arr[i] = -1;
        // }
        // int t = 0;
        // for(int i=0;i<n;i++){
        //     for(int j=0;j<m;j++){
        //         if(nums1[i]==nums2[j]){
        //         int x=j+1;
        //             while(x<m && nums2[j]>=nums2[x]){
        //                 x++;
        //             }
        //             if(x<m){
        //                 arr[i] = nums2[x];
        //             }
                    
        //         }
        //     }
        // }
        // return arr;

        for(int i=nums2.length-1;i>=0;i--){
            while(!st.isEmpty() && st.peek()<=nums2[i]){
                st.pop();
            }
            if(st.isEmpty()){
                mp.put(nums2[i],-1);
            } else{
                mp.put(nums2[i],st.peek());
            }
            st.push(nums2[i]);
            
        }
        for(int i=0;i<n;i++){
            arr[i] = mp.get(nums1[i]);
        }
        return arr;
    }
}