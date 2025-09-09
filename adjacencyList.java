import java.util.*;

class Solution {
    // Function to build adjacency list from edge list
    public List<List<Integer>> buildAdjList(int V, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        
        // initialize adjacency list
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        // add edges (assuming undirected graph)
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);  // remove this line if graph is directed
        }

        return adj;
    }
}
