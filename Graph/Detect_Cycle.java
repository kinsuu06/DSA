class Solution {
    public boolean isCycle(int v, List<List<Integer>> adj) {
        HashSet<Integer> visited = new HashSet<>();

        for (int i = 0; i < v; i++) {
            if (!visited.contains(i)) {
                if (checkCycle(i, adj, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkCycle(int s, List<List<Integer>> adj, HashSet<Integer> visited) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{s, -1});
        visited.add(s);
        
        while (!q.isEmpty()) {
            int[] rv = q.poll();
            int node = rv[0];
            int parent = rv[1];

            for (int neighbor : adj.get(node)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    q.add(new int[]{neighbor, node});
                } else if (neighbor != parent) {
                    return true; // Cycle found
                }
            }
        }
        return false;
    }
}
