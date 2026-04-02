import java.util.*;

class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        int n = positions.length;
        Integer[] ids = new Integer[n];
        
        // Initialize an array of indices to keep track of the original order
        for (int i = 0; i < n; i++) {
            ids[i] = i;
        }
        
        // Sort the indices based on the robots' starting positions (Left to Right)
        Arrays.sort(ids, (a, b) -> Integer.compare(positions[a], positions[b]));
        
        // Use a stack to keep track of robots that might collide
        Deque<Integer> stack = new ArrayDeque<>();
        
        for (int id : ids) {
            // If moving Right, push to stack (it might collide with future 'L' robots)
            if (directions.charAt(id) == 'R') {
                stack.push(id);
            } else {
                // If moving Left, check for collisions with 'R' robots in the stack
                while (!stack.isEmpty() && directions.charAt(stack.peek()) == 'R') {
                    int topId = stack.peek();
                    
                    if (healths[topId] == healths[id]) {
                        // Both robots have the same health; both are destroyed
                        healths[topId] = 0;
                        healths[id] = 0;
                        stack.pop();
                        break;
                    } else if (healths[topId] > healths[id]) {
                        // The 'R' robot (on stack) wins; 'L' robot is destroyed
                        healths[topId]--;
                        healths[id] = 0;
                        break;
                    } else {
                        // The 'L' robot (current) wins; 'R' robot is destroyed
                        healths[topId] = 0;
                        healths[id]--;
                        stack.pop();
                    }
                }
                
                // If the 'L' robot survived all collisions, it moves safely to the left
                // We add it to the stack so it stays in the survivor pool
                if (healths[id] > 0) {
                    stack.push(id);
                }
            }
        }
        
        // Collect the healths of the surviving robots in their original given order
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (healths[i] > 0) {
                result.add(healths[i]);
            }
        }
        
        return result;
    }
}