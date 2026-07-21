class Solution {
    public int maxPower(String s) {
        int n = s.length();
        HashMap<Character,Integer>mp=new HashMap<>();
        int l = 0,max=0;
        for(int i=0;i<n;i++){
            char ch = s.charAt(i);
            mp.put(ch,mp.getOrDefault(ch,0)+1);
            while(mp.size()>1){
                char cl = s.charAt(l);
                mp.put(cl,mp.get(cl)-1);
                l++;
                if(mp.get(cl)==0){
                    mp.remove(cl);
                }
            }
            max = Math.max(max,i-l+1);
        }
        return max;
    }
}