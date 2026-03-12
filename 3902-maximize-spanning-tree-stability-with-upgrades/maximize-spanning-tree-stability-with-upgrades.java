class Solution {
    public int maxStability(int n, int[][] edges, int k) {
        int[] base_parent = new int[n];
        int[] base_rank = new int[n];
        for (int i = 0; i < n; i++) base_parent[i] = i;
        
        int min_must = Integer.MAX_VALUE;
        int base_components = n;
        
        // 1. Process mandatory edges first
        for (int[] edge : edges) {
            if (edge[3] == 1) { 
                if (!union(base_parent, base_rank, edge[0], edge[1])) {
                    // Cycle detected in mandatory edges -> Spanning tree impossible
                    return -1; 
                }
                base_components--;
                min_must = Math.min(min_must, edge[2]);
            }
        }
        
        // 2. Initial check: Is it even possible to connect all nodes?
        int[] test_parent = base_parent.clone();
        int[] test_rank = base_rank.clone();
        int test_components = base_components;
        for (int[] edge : edges) {
            if (edge[3] == 0) {
                if (union(test_parent, test_rank, edge[0], edge[1])) {
                    test_components--;
                    if (test_components == 1) break; // Connected successfully
                }
            }
        }
        
        if (test_components > 1) {
            return -1; // Cannot form a spanning tree with all edges
        }
        
        // 3. Binary Search for maximum stability
        int low = 1;
        // The max strength is 10^5, so max possible upgraded strength is 2 * 10^5
        int high = Math.min(min_must, 200000); 
        int ans = 1;
        
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (check(mid, edges, base_parent, base_rank, base_components, k, n)) {
                ans = mid;
                low = mid + 1; // Try to find a higher stability
            } else {
                high = mid - 1; // Reduce target stability
            }
        }
        
        return ans;
    }
    
    // Helper function to verify if target stability X is achievable
    private boolean check(int X, int[][] edges, int[] base_parent, int[] base_rank, int base_components, int k, int n) {
        if (base_components == 1) return true; // Already connected by mandatory edges
        
        int[] parent = base_parent.clone();
        int[] rank = base_rank.clone();
        int components = base_components;
        int upgrades = 0;
        
        // Pass 1: Greedily process 0-cost optional edges (strength >= X)
        for (int[] edge : edges) {
            if (edge[3] == 0 && edge[2] >= X) {
                if (union(parent, rank, edge[0], edge[1])) {
                    components--;
                    if (components == 1) return true; // Early exit if graph is connected
                }
            }
        }
        
        // Pass 2: Process 1-cost optional edges (requires upgrade to meet X)
        for (int[] edge : edges) {
            if (edge[3] == 0 && edge[2] < X && edge[2] * 2 >= X) {
                if (union(parent, rank, edge[0], edge[1])) {
                    components--;
                    upgrades++;
                    if (upgrades > k) return false; // Exceeded upgrade budget
                    if (components == 1) return true;
                }
            }
        }
        
        return components == 1 && upgrades <= k;
    }
    
    // DSU: Find with path halving
    private int find(int[] parent, int i) {
        int root = i;
        while (root != parent[root]) {
            parent[root] = parent[parent[root]];
            root = parent[root];
        }
        return root;
    }
    
    // DSU: Union by rank
    private boolean union(int[] parent, int[] rank, int i, int j) {
        int rootI = find(parent, i);
        int rootJ = find(parent, j);
        if (rootI != rootJ) {
            if (rank[rootI] < rank[rootJ]) {
                parent[rootI] = rootJ;
            } else if (rank[rootI] > rank[rootJ]) {
                parent[rootJ] = rootI;
            } else {
                parent[rootJ] = rootI;
                rank[rootI]++;
            }
            return true;
        }
        return false;
    }
}