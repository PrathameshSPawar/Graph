//https://www.geeksforgeeks.org/problems/distance-of-nearest-cell-having-1-1587115620/1
//https://leetcode.com/problems/01-matrix/description/
class Pair {
    int first;
    int sec;
    int time;
    public Pair(int first,int sec,int time) {
        this.first=first;
        this.sec=sec;
        this.time=time;
    }
}
class Solution {
    // Function to find distance of nearest 1 in the grid for each cell.
    public int[][] nearest(int[][] grid) {
        // Code here
        int n=grid.length;
        int m=grid[0].length;
        int visited[][]=new int[n][m];
        int ans[][]=new int[n][m];
        Queue<Pair> q=new LinkedList<>();
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(grid[i][j]==1) {
                    q.offer(new Pair(i,j,0));
                    visited[i][j]=1;
                } else {
                    visited[i][j]=0;
                }
            }
        }
        int drow[]={-1,0,0,1};
        int dcol[]={0,-1,1,0};
        
        
        while(!q.isEmpty()) {
            Pair p = q.poll();
            int left=p.first;
            int right=p.sec;
            int time=p.time;
            for(int i=0;i<4;i++) {
                int l=left+drow[i];
                int r=right+dcol[i];
                if(l>=0 && r>=0 && l<n && r<m && visited[l][r]==0) {
                    q.offer(new Pair(l,r,time+1));
                    visited[l][r]=1;
                }
            }
            ans[left][right]=time;
        }
        return ans;
    }
}
