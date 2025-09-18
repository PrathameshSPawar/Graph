//https://leetcode.com/problems/is-graph-bipartite/description/
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
