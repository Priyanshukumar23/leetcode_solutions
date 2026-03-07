class Solution {
    public int totalFruit(int[] fruits) {
        HashMap<Integer,Integer>mp = new HashMap<>();
        int n = fruits.length;
        int l=0,max=0,r=0;
        for(int i=0;i<n;i++){
            mp.put(fruits[i],mp.getOrDefault(fruits[i],0)+1);
            while(mp.size()>2){
               mp.put(fruits[l], mp.get(fruits[l]) - 1);
               
            if(mp.get(fruits[l])==0)mp.remove(fruits[l]);
            l++;
            }
            if(mp.size()<=2){

                max = Math.max(max,i-l+1);
            }
        }
        return max;
    }
}