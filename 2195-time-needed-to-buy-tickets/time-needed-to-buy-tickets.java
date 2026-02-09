class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int n = tickets.length;
        int s = 0;
        int i=0;
        while(tickets[k]!=0){
            
            if(i==n){
                i=0;
            }
            if(tickets[i]>0){

            tickets[i] -= 1;
            s++;
            }
            i++;
        }
    return s;
    }
}