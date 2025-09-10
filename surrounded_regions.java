//https://leetcode.com/problems/surrounded-regions/
class Pair {
    int row;
    int col;
    public Pair(int row,int col) {
        this.row=row;
        this.col=col;
    }
}
//we use BFS technique to solve
//firstly check entire boundary if their is any cell which contain O in boundary
//so take them into our queue so we can mark them as region 
class Solution {
    public void solve(char[][] board) {
        int n=board.length,m=board[0].length;
        int visited[][]=new int[n][m];
        Queue<Pair> q = new LinkedList<>();
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if((i==0 || j==0 || i==n-1 || j==m-1 ) && board[i][j]=='O') {
                    q.offer(new Pair(i,j));
                }
            }
        }

        int drow[]={-1,0,0,1};
        int dcol[]={0,-1,1,0};
        while(!q.isEmpty()) {
            Pair p = q.poll();
            int left=p.row;
            int right=p.col;
            visited[left][right]=1;
            for(int i=0;i<4;i++) {
                int r=left+drow[i];
                int c=right+dcol[i];
                if(r>=0 && c>=0 && r<n && c<m && board[r][c]=='O' && visited[r][c] == 0) {
                    q.offer(new Pair(r,c));
                }
            }
        }

        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(visited[i][j]!=1 && board[i][j]=='O') {
                    board[i][j]='X';
                }
            }
        }
    }
}
