class Solution {
    public int maxVowels(String s, int k) {
        int n = s.length();
        int c=0,l=0,max=0;
        for(int i=0;i<k;i++){
            char ch = s.charAt(i);
            if(isv(ch)){
                c++;
            }
        }
        max = c;
        for(int i=k;i<n;i++){
            char ch = s.charAt(i);
            if(isv(ch)){
                c++;
            } 
            if(isv(s.charAt(i-k))){
                c--;
            }
            max = Math.max(max,c);
        }
        return max;
    }
    public boolean isv(char ch){
        return ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u';
    }
}