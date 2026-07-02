class Solution {
    public String frequencySort(String s) {
        int n = s.length();
    //     StringBuilder sb = new StringBuilder();
       
    //     int[] fr = new int[256];
    //     for(int i=0;i<n;i++){
    //         char ch = s.charAt(i);
    //         fr[ch]++;
    //     }
    //     char[] ch = new char[256];
    //     for(int i=0;i<256;i++){
    //         ch[i] = (char)i;
    //     }
    //     for(int i=0;i<256;i++){
    //         //char ch = s.charAt(i);
    //         for(int j = i;j<256;j++){
                
    //             if(fr[i]<fr[j] ){
    //                 int t = fr[i];
    //                 fr[i] = fr[j];
    //                 fr[j] = t;

    //                 char x = ch[i];
    //                 ch[i] = ch[j];
    //                 ch[j] = x;
    //             }
    //         }
    //     }
    //    for(int i=0;i<256;i++){
    //     while(fr[i]-->0){
    //         sb.append(ch[i]);
    //     }
    //    }
    //     return sb.toString();
    // }


    HashMap<Character,Integer>mp = new HashMap<>();
    for(char ch:s.toCharArray()){
        mp.put(ch,mp.getOrDefault(ch,0)+1);
    }
    List<Character>chars = new ArrayList<>(mp.keySet());
    Collections.sort(chars,(a,b)->mp.get(b)-mp.get(a));
    StringBuilder sb = new StringBuilder();
    for(char c:chars){
        int x = mp.get(c);
        while(x-->0){
            sb.append(c);
        }
        
    }
    return sb.toString();
}
}