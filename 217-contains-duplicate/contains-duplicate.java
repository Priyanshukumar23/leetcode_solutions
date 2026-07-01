class Solution {
    public boolean containsDuplicate(int[] nums) {
        int n = nums.length;
        boolean c = false;
        HashMap<Integer,Integer>mp = new HashMap<>();
        for(int i=0;i<n;i++){
            mp.put(nums[i],mp.getOrDefault(nums[i],0)+1);
            
        }
        for(int i=0;i<n;i++){
            if(mp.get(nums[i])>1){
                c= true;
            }
            
        }
            return c;
    }
}


// class Solution {
//     public boolean containsDuplicate(int[] nums) {

//         HashMap<Integer, Integer> mp = new HashMap<>();

//         for (int num : nums) {

//             if (mp.containsKey(num)) {
//                 return true;
//             }

//             mp.put(num, 1);
//         }

//         return false;
//     }
// }