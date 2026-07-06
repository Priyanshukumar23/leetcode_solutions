class Solution {
    public boolean check(int[] fr1,int[] fr2){
        for(int i=0;i<26;i++){
            if(fr1[i]!=fr2[i])return false;
        }
        return true;
    }
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        if(n>m)return false;
        int[] fr1 = new int[26];
        int[] fr2 = new int[26];
        for(int i=0;i<n;i++){
            char ch = s1.charAt(i);
            fr1[ch-'a']++;
        }

         for(int i=0;i<n;i++){
            char ch = s2.charAt(i);
            fr2[ch-'a']++;
        }
        if(check(fr1,fr2))return true;
        for(int i=n;i<m;i++){
            fr2[s2.charAt(i)-'a']++;
            fr2[s2.charAt(i-n)-'a']--;
            if(check(fr1,fr2))return true;
        }
        return false;
    }
}