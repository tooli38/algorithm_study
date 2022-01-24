package study0118;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class acm2089 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int n = 5;
        int[][] results = {{4,3},{4, 2}, {3, 2},{1, 2}, {2, 5}};
        System.out.println(solution(n, results));
    }

    private static int solution(int n, int[][] results) {
        int answer = 0;

        int[][] arr = new int[n+1][n+1];

        Arrays.stream(results)
                .forEach(e -> arr[e[0]][e[1]] = 1);

        //출발지점 선택
        for(int i = 1; i <= n; i++){

            //중간지점 선택
            for(int j = 1; j <= n; j++){
                if(i == j) continue;
                if(arr[i][j] == 1){
                    //종점 선택
                    for(int k = 1; k <= n; k++){
                        if(k == j || k == i) continue;
                        if(arr[j][k] == 1){
                            arr[i][k] = 1;
                        }
                    }
                }
            }
        }

        for(int i = 1; i <= n; i++){
            int cnt = 0;
            for(int j = 1; j <= n; j++){
                if(arr[i][j] == 1 || arr[j][i] == 1){
                    cnt++;
                }
            }
            if(cnt == n-1) answer++;
        }
        return answer;
    }
}
