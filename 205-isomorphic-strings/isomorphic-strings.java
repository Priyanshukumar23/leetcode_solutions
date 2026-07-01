class Solution {
    public boolean isIsomorphic(String s, String t) {
        int n = s.length();
        int y = t.length();
        if(n!=y)return false;
        // HashMap<Character,Integer>mp = new HashMap<>();
        // HashMap<Character,Integer>mp2 = new HashMap<>();
        // for(int i=0;i<n;i++){
        //     char ch = s.charAt(i);
        //     char cl = t.charAt(i);
        //     mp.put(ch,mp.getOrDefault(ch,0)+1);
        //     mp2.put(cl,mp2.getOrDefault(cl,0)+1);
        // }
        // for(int i=0;i<n;i++){
        //     char ch = s.charAt(i);
        //     char cl = t.charAt(i);
        //     if(mp.get(ch)!=mp2.get(cl)){
        //         return false;
        //     }
        // }
        // return true;
        HashMap<Character,Character>mp = new HashMap<>();
        HashMap<Character,Character>mp2 = new HashMap<>();
        for(int i=0;i<n;i++){
            char a = s.charAt(i);
            char b = t.charAt(i);
            if(mp.containsKey(a) && mp.get(a)!=b){
                return false;
            }
            if(mp2.containsKey(b) && mp2.get(b)!=a){
                return false;
            }
            mp.put(a,b);
            mp2.put(b,a);
        }
        return true;
    }
}