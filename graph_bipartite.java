//https://leetcode.com/problems/is-graph-bipartite/description/
//BFS SOLUTION
class Solution {
    public boolean isBipartite(int[][] graph) {
        int n=graph.length;
        int color[]=new int[n];
        Arrays.fill(color,-1);
        for(int i=0;i<n;i++) {
            if(color[i]==-1 && check(i,graph,color)==false) return false;
        }
        return true;
    }

    public boolean check(int node,int graph[][],int color[]) {
        Queue<Integer> q=new LinkedList<>();
        q.offer(node);
        color[node]=0; 
        while(!q.isEmpty()) {
            int curr=q.poll();
            for(int i : graph[curr]) {
                if(color[i]==-1) {
                    color[i]=1-color[curr];
                    q.offer(i);
                } else if(color[i]==color[curr]) {
                    return false;
                }
            }
        }
        return true;        
    }
}


//DFS SOLUTION
class Solution {
    public boolean isBipartite(int V, int[][] edges) {
        // Code here
        int color[]=new int[V];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0 ;i<V;i++) {
            adj.add(new ArrayList<Integer>());
        }
        
        for(int i[] : edges) {
            adj.get(i[0]).add(i[1]);
            adj.get(i[1]).add(i[0]);
        }
        Arrays.fill(color,-1);
        for(int i=0;i<V;i++) {
            if(color[i]==-1) {
                if(dfs(i,0,adj,color)==false) {
                    return false;
                };
            }
        }
        return true;
    }
    
    public boolean dfs(int node,int col,ArrayList<ArrayList<Integer>> adj,int color[]) {
        color[node]=col;
        //color[node]=1-col;
        for(int i : adj.get(node)) {
            if(color[i]==-1 ) {
                if(dfs(i,1-col,adj,color)==false) return false;
            }else if(color[i]==col) {
                return false;
            }
        }
        return true;
    }
}
