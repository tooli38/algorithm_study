package study0121;

import java.util.Arrays;

public class dbq4 {

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int[][] dp;

    public static void main(String[] args) {
        int[][] map = {
                {0,0,0,0,0,0,0},
                {0,1,0,1,0,1,0},
                {0,1,1,1,1,1,1},
                {0,0,0,0,0,0,1},
                {0,1,1,1,1,1,1},
                {0,1,1,1,1,1,1}
//                {0, 0, 0, 0},
//                {0, 1, 1, 0},
//                {0, 0, 1, 0},
//                {0, 0, 1, 1}
        };
        int N = map.length-1;
        int M = map[0].length-1;
        dp = new int[N+1][M+1];
        for (int[] i : dp){
            Arrays.fill(i, N*M+1);
        }
        System.out.println(solution(N,M,map));
    }

    private static int solution(int n, int m, int[][] map) {
        dfs(1,1, 1, n, m ,map);
        return dp[n][m];
    }

    private static void dfs(int x, int y, int cnt, int n, int m, int[][] map) {
        //종단 조건
        if(x == n && y == m) {
            return;
        }

        for(int i = 0; i < 4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(nx > 0 && nx <= n && ny > 0 && ny <= m && dp[nx][ny] > cnt && map[nx][ny] == 1){
                dp[nx][ny] = cnt+1;
                dfs(nx, ny, cnt+1, n, m, map);
            }
        }
    }
}
