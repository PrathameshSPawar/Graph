class Solution {
    public int numIslands(char[][] grid) {
        int islands=0;
        int n=grid.length,m=grid[0].length;
        int visited[][]=new int[n][m];
        for(int i[] : visited) {
            Arrays.fill(i,0);
        }

        int dir[][]={{-1,0},{0,-1},{0,1},{1,0}};
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(visited[i][j]==0 && grid[i][j]=='1') {
                    islands++;
                    visited[i][j]=1;
                    Queue<List<Integer>> q=new LinkedList<>();
                    q.offer(Arrays.asList(i, j)); 
                    while(!q.isEmpty()) {
                        List<Integer> current=q.poll();
                        // for(int i1=-1;i1<=1;i1++) {
                        //     for(int j1=;j1<=1;j1++) {
                        for(int d[] : dir){
                                int one=d[0]+current.get(0);
                                int two=d[1]+current.get(1);
                                if(one<0 || one>=n || two<0 || two>=m) {
                                    continue;
                                }
                                if (visited[one][two] == 0 && grid[one][two] == '1') {
                                    q.offer(Arrays.asList(one,two));
                                    visited[one][two]=1;
                                }
                        }
                    }                  
                }
                visited[i][j]=1;
            }
        }
        return islands;
    }
}
