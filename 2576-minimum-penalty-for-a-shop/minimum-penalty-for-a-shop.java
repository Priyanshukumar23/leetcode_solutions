class Solution {
    public int bestClosingTime(String customers) {
        int n = customers.length();
        int s = 0,p=0,l=0;
        for(int i=0;i<n;i++){
            char ch = customers.charAt(i);
            if(ch=='Y')s++;
        }
        int min = s;
        for(int i=0;i<n;i++){
            if(customers.charAt(i)=='Y'){
                s--;
            } else{
                s++;
            }
            if(s<min){
                min = s;
                p = i+1;
            }
        }
        return p;
    }
}