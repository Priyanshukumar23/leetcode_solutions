class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
    //     int n = tickets.length;
    //     int s = 0;
    //     int i=0;
    //     while(tickets[k]!=0){
            
    //         if(i==n){
    //             i=0;
    //         }
    //         if(tickets[i]>0){

    //         tickets[i] -= 1;
    //         s++;
    //         }
    //         i++;
    //     }
    // return s;
     int time = 0;
        int target = tickets[k];

        for (int i = 0; i < tickets.length; i++) {
            if (i <= k) {
                time += Math.min(tickets[i], target);
            } else {
                time += Math.min(tickets[i], target - 1);
            }
        }
        return time;
    }
}