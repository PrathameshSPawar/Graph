// User function Template for Java
//https://www.geeksforgeeks.org/problems/number-of-distinct-islands/1
class Pair {
    int first;
    int second;
    public Pair(int first , int second) {
        this.first=first;
        this.second=second;
    }
}

class Solution {
    String toString(int a,int b) {
        return Integer.toString(a)+" "+Integer.toString(b);
    }
    void dfs(int i,int j,int grid[][],int visited[][],List<String> list,int i0,int j0) {
        int n=grid.length;
        int m=grid[0].length;
        list.add(toString(i-i0,j-j0));
        int drow[]={-1,0,1,0};
        int dcol[]={0,1,0,-1};
        visited[i][j]=1;
        for(int i1=0;i1<4;i1++) {
            int row = i +drow[i1];
            int col = j +dcol[i1];
            if(row>=0 && col>=0 && row<n && col<m) {
                if(visited[row][col]==0 && grid[row][col]==1) {
                    dfs(row,col,grid,visited,list,i0,j0);
                }
            }
        }
    }

    int countDistinctIslands(int[][] grid) {
        // Your Code here
        int drow[]={-1,0,1,0};
        int dcol[]={0,1,0,-1};
        int n=grid.length;
        int m=grid[0].length;
        int visited[][]=new int[n][m];
        for(int i[] : visited) {
            Arrays.fill(i,0);
        }
        HashSet<List<String>> set= new HashSet<>();
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                List<String> list = new ArrayList<>();
                if(visited[i][j]==0 && grid[i][j]==1) {
                    dfs(i,j,grid,visited,list,i,j);
                    set.add(list);
                }
            }
        }
        return set.size();
    }
}
