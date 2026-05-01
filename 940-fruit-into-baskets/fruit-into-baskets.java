class Solution {
    public int totalFruit(int[] fruits) {
        HashMap<Integer,Integer>mp = new HashMap<>();
        
        int l=0,max=0;
        int n = fruits.length;
        for(int i=0;i<n;i++){
            mp.put(fruits[i],mp.getOrDefault(fruits[i],0)+1);
            while(mp.size()>2){
                mp.put(fruits[l],mp.get(fruits[l])-1);
                if(mp.get(fruits[l])==0){

                mp.remove(fruits[l]);
                }
                l++;
            }
            
            max = Math.max(i-l+1,max);
        }
        return max;
    }
}