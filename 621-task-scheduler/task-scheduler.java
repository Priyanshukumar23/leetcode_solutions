class Solution {
    public int leastInterval(char[] tasks, int n) {
        int x = tasks.length;
        int[] fr = new int[26];
        for(int ch:tasks){
            fr[ch-'A']++;
        }
        int max = 0;
        int mf = 0;
        for(int num:fr){
            max = Math.max(max,num);
        }
        for(int num:fr){
            if(num==max)mf++;
        }
        int t = (max-1)*(n+1)+mf;
        return Math.max(t,x);
    }
}