class Solution {
    public int minStartValue(int[] nums) {
        int n = nums.length;
        int l=1,max=0,min=0;
        int x = l;
        boolean ok = true;
        while(true){
            ok = true;
            // l = x;
            for(int i=0;i<n;i++){
            l = l+nums[i];
            if(l<=0){
                // x++;
                l = x;
                l = l+1;
                x = l;
                ok = false;
                break;
                
            } 
        }
        if(ok){
            return x;
        }
        }
        
        

        
    }
}