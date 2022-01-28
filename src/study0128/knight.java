package study0128;

import java.util.Scanner;

public class knight {

    static int[][] knightMove = {{1, 2},{2, 1}}; //수평 1, 수직 2 | 수평 2, 수직 1
    static int[][] direction = {{1, 1}, {1, -1}, {-1, 1}, {-1, -1}}; //상하좌우
    static int maxMap = 7;
    static int minMap = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        int column = input.charAt(0) - 'a';
        int row = input.charAt(1) - '1';

        int ans = 0;

        for(int[] i : knightMove)
            for(int[] j : direction){
                int nx = row + i[0]*j[0];
                int ny = column + i[1]*j[1];
                if(nx <= maxMap && nx >= minMap && ny <= maxMap && ny >= minMap)
                    ans++;
            }
        System.out.println(ans);
    }
}
