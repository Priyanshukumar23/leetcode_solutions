import java.util.*;

class Solution {
    public boolean canCross(int[] stones) {
        
        // Map: stone -> possible jump sizes
        Map<Integer, Set<Integer>> map = new HashMap<>();

        // Initialize map
        for (int stone : stones) {
            map.put(stone, new HashSet<>());
        }

        // Start from stone 0 with jump 1
        map.get(0).add(1);

        // Traverse stones
        for (int stone : stones) {
            for (int jump : map.get(stone)) {

                int reach = stone + jump;

                // If reached last stone
                if (reach == stones[stones.length - 1]) {
                    return true;
                }

                // If next stone exists
                if (map.containsKey(reach)) {

                    if (jump - 1 > 0)
                        map.get(reach).add(jump - 1);

                    map.get(reach).add(jump);

                    map.get(reach).add(jump + 1);
                }
            }
        }

        return false;
    }
}