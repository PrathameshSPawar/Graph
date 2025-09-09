public class Pair {
    int row;
    int col;
    int time;
    public Pair(int row,int col,int time) {
        this.row=row;
        this.col=col;
        this.time=time;
    }
}
class Solution {
    public int orangesRotting(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int visited[][]=new int[n][m];
        int fresh=0;
        Queue<Pair> q=new LinkedList<>();
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(grid[i][j] == 2) {
                    q.offer(new Pair(i,j,0));
                    visited[i][j]=2;
                }

                if(grid[i][j]==1) fresh++;
            }
        }

        int count=0,tm=0;
        int drow[] = {-1,0,0,1};
        int dcol[] = {0,-1,1,0};
        while(!q.isEmpty()) {
            Pair p = q.poll();
            int one=p.row;
            int sec=p.col;
            int time=p.time;
            tm=Math.max(time,tm);
            for(int i=0;i<4;i++) {
                int r= drow[i]+one;
                int c=dcol[i]+sec;
                if(r>=0 && r<n && c>=0 && c<m && grid[r][c]==1 && visited[r][c]==0) {
                    visited[r][c]=1;
                    q.offer(new Pair(r,c,time+1));
                    count++;    
                }
            }
        }
        if(count!=fresh) return -1;
        return tm;
    }
}
