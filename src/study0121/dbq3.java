package study0121;

import java.util.LinkedList;
import java.util.Queue;

public class dbq3 {

    static int dx[] = {1, -1, 0, 0};
    static int dy[] = {0, 0, 1, -1};

    public static void main(String[] args) {
        int[][] map = {
                {0,0,1,1,0},
                {0,0,0,1,1},
                {1,1,1,1,1},
                {0,0,0,0,0}
        };
        int N = 4;
        int M = 5;

        System.out.println(solution(N, M, map));;
    }

    private static int solution(int n, int m, int[][] map) {
        int ans = 0;

        boolean visited[][] = new boolean[n][m];

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if (map[i][j] == 0 && visited[i][j] == false) {
                    //멥의 x,y좌표
                    Queue<int[]> q = new LinkedList<>();
                    q.offer(new int[]{i,j});
                    visited[i][j] = true;

                    while(!q.isEmpty()){
                        int[] tp = q.poll();

                        for(int k = 0; k < 4; k++){
                            int nx = tp[0] + dx[k];
                            int ny = tp[1] + dy[k];
                            if(nx>=0 && nx < n && ny >=0 && ny < m && map[nx][ny] == 0 && visited[nx][ny] == false){
                                q.offer(new int[]{nx,ny});
                                visited[nx][ny] = true;
                            }
                        }
                    }
                    ans++;
                }
            }
        }

        return ans;
    }


}
