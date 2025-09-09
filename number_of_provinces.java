class Solution {
    public void dfs(int node,int visited[],ArrayList<ArrayList<Integer>> list) {
        visited[node] = 1;
        for(int i : list.get(node)) {
            if(visited[i]==0) {
                dfs(i,visited,list);
            }
        }
    }

    public int findCircleNum(int[][] isConnected) {
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<ArrayList<Integer>>();
        int V = isConnected.length;
        for(int i=0;i<V;i++) {
            adjList.add(new ArrayList<Integer>());
        }

        for(int i=0;i<V;i++) {
            for(int j=0;j<V;j++) {
                if(isConnected[i][j]==1 && i!=j) {
                    adjList.get(i).add(j);
                    adjList.get(j).add(i);
                }
            }
        }
        int visited[] = new int[V];
        int count=0;
        Arrays.fill(visited,0);
        for(int i=0;i<V;i++) {
            if(visited[i]==0) {
                count++;
                dfs(i,visited,adjList);
            }
        }

        return count;
    }
}
