class Solution {
    public int minAddToMakeValid(String s) {
        int n = s.length();
        int c = 0;
        int op = 0;
        // for(int i=0;i<n;i++){
        //     char ch = s.charAt(i);
        //     if(ch=='('){
        //         op++;
        //     } else{
        //         if(op>0){
        //             op--;
        //         } else{
        //             c++;
        //         }
        //     }
            
        // }
        // return op+c;

        Stack<Character>st = new Stack<>();
        for(int i=0;i<n;i++){
            char ch = s.charAt(i);
            if(ch=='(')st.push(ch);
            else{
                if(!st.isEmpty() && st.peek()=='('){
                    st.pop();
                } else{
                    st.push(ch);
                }
            }
        }
        return st.size();
    }
}