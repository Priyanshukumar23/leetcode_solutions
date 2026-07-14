class Solution {
    public int[] dailyTemperatures(int[] tem) {
        int n = tem.length;
        int[] arr = new int[n];
        // for(int i=0;i<n;i++){
        //     arr[i] = 0;
        // }
        // for(int i=0;i<n;i++){
        //     int x=i+1;
        //     int c=1;
        //     while(x<n && tem[i]>=tem[x]){
        //         x++;
        //         c++;
        //     }
        //     if(x<n){
        //         arr[i] = c;
        //     }
        // }
        // return arr;

        Stack<Integer>st = new Stack<>();
        for(int i=n-1;i>=0;i--){
            int c=1;
            while(!st.isEmpty() && tem[st.peek()]<=tem[i]){
                st.pop();
            }
            if(!st.isEmpty()){
                arr[i] = st.peek()-i;
            } else{
                arr[i] = 0;
            }
            st.push(i);
        }
        return arr;
    }
}