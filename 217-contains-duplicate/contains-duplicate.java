
class Solution {
    public boolean containsDuplicate(int[] nums) {

        HashMap<Integer, Integer> mp = new HashMap<>();

        for (int num : nums) {

            if (mp.containsKey(num)) {
                return true;
            }

            mp.put(num, 1);
        }

        return false;
    }
}