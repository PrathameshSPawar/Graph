//https://www.geeksforgeeks.org/problems/detect-cycle-in-an-undirected-graph/1
//in both way BFS and DFS
class Pair {
    int val;
    int parent;
    public Pair(int val,int parent) {
        this.val=val;
        this.parent=parent;
    }
}

class Solution {
    public boolean bfs(int src,List<List<Integer>> adj,int visited[]) {
        Queue<Pair> q=new LinkedList<>();
        q.offer(new Pair(src,-1));
        visited[src]=1;
        while((!q.isEmpty())) {
            Pair p = q.poll();
            int val=p.val;
            int parent=p.parent;
            for(int adjecentNode : adj.get(val)) {
                if(visited[adjecentNode]==0) {
                    visited[adjecentNode]=1;
                    q.offer(new Pair(adjecentNode,val));
                } else if(adjecentNode!=parent) {
                    return true;
                }
            }
        }
        return false;
    }
    
    
    public boolean dfs(Pair src,List<List<Integer>> adj,int visited[]) {
        int val=src.val;
        int parent=src.parent;
        visited[val]=1;
        for(int adjecent : adj.get(val)) {
            if(visited[adjecent]==0) {
                if(dfs(new Pair(adjecent,val),adj,visited)==true) {
                    return true;
                }
            } else if(adjecent!=parent) {
                return true;
            }
        }
        return false;
    }
    
    public boolean isCycle(int V, int[][] edges) {
        // Code here
        List<List<Integer>> adj = new ArrayList<>();
        adjacency(V,edges,adj);
        //Queue<Pair> q = new LinkedList<>();
        //q.offer(new Pair(0,-1));
        int visited[]=new int[V];
        Arrays.fill(visited,0);
        for(int i=0;i<V;i++) {
            if(visited[i]==0) {
                boolean ans=dfs(new Pair(i,-1),adj,visited);
                //boolean ans=bfs(i,adj,visited);
                if(ans==true) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public void adjacency(int V,int edges[][],List<List<Integer>> list){
        for(int i=0;i<V;i++) {
            list.add(new ArrayList<Integer>());
        }
        
        for(int i[] : edges) {
            int first=i[0];
            int sec=i[1];
            list.get(first).add(sec);
            list.get(sec).add(first);
        }
    }
}
