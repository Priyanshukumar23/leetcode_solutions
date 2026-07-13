class Solution {
    public int minAddToMakeValid(String s) {
        int n = s.length();
        int c = 0;
        int op = 0;
        for(int i=0;i<n;i++){
            char ch = s.charAt(i);
            if(ch=='('){
                op++;
            } else{
                if(op>0){
                    op--;
                } else{
                    c++;
                }
            }
            
        }
        return op+c;
    }
}