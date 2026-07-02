class Solution {
    public String frequencySort(String s) {
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        // HashMap<Character,Integer>mp = new HashMap<>();
        // for(int i=0;i<n;i++){
        //     char ch = s.charAt(i);
        //     mp.put(ch,mp.getOrDefault(ch,0)+1);
        // }

        // for(int i=0;i<n;i++){
        //     char ch = s.charAt(i);
        //     for(int j=i+1;j<n;j++){
        //         if(mp.get(ch)<mp.get(s.charAt(j))){
        //             sb.append(s.charAt(j));
        //         } 
        //     }
        //     //sb.append(ch);
        // }
        // return sb.toString();

        int[] fr = new int[256];
        for(int i=0;i<n;i++){
            char ch = s.charAt(i);
            fr[ch]++;
        }
        char[] ch = new char[256];
        for(int i=0;i<256;i++){
            ch[i] = (char)i;
        }
        for(int i=0;i<256;i++){
            //char ch = s.charAt(i);
            for(int j = i;j<256;j++){
                
                if(fr[i]<fr[j] ){
                    int t = fr[i];
                    fr[i] = fr[j];
                    fr[j] = t;

                    char x = ch[i];
                    ch[i] = ch[j];
                    ch[j] = x;
                }
            }
        }
       for(int i=0;i<256;i++){
        while(fr[i]-->0){
            sb.append(ch[i]);
        }
       }
        return sb.toString();
    }
}