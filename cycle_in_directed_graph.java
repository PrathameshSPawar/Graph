//https://www.geeksforgeeks.org/problems/detect-cycle-in-a-directed-graph/1
class Solution {
    public boolean dfs(int node,List<List<Integer>> li,int visited[],int curr[])
    {
        visited[node]=1;
        curr[node]=1;
        for(int i : li.get(node)) {
            if(visited[i]==0) {
                if(dfs(i,li,visited,curr)==true) return true;
            } else if(curr[i]==1) {
                return true;
            }
        }
        
        curr[node]=0;
        return false;
    }
    
    public boolean isCyclic(int V, int[][] edges) {
        // code here
        List<List<Integer>> li = new ArrayList<>();
        for(int i=0;i<V;i++) {
            li.add(new ArrayList<>());
        }
        
        for(int i[] : edges) {
            li.get(i[0]).add(i[1]);
        }
        
        int visited[] = new int[V];
        int curr[] = new int[V];
        for(int i=0;i<V;i++) {
            if(visited[i]==0) {
                if(dfs(i,li,visited,curr)==true) {
                    return true;
                };
            }
        }
        return false;
    }
}
