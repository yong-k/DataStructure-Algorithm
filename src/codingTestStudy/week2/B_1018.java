package codingTestStudy.week2;

// https://st-lab.tistory.com/101
import java.util.*;
public class B_1018 {
    static boolean[][] arr;
    static int min = 64;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        arr = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String s = sc.next();
            for (int j = 0; j < M; j++) {
                if (s.charAt(j) == 'W')
                    arr[i][j] = true;
                else
                    arr[i][j] = false;
            }
        }

        int N_row = N - 7;
        int N_col = M - 7;
        for (int i = 0; i < N_row; i++) {
            for (int j = 0; j < N_col; j++) {
                find(i, j);
            }
        }
        System.out.println(min);
    }

    static void find(int x, int y) {
        int end_x = x + 8;
        int end_y = y + 8;
        int count = 0;
        boolean colorCheck = arr[x][y];

        for (int i = x; i < end_x; i++) {
            for (int j = y; j < end_y; j++) {
                // 올바른 색 아니면 count 증가
                if (arr[i][j] != colorCheck)
                    count++;

                // 색깔 바뀌니까 값 변경
                colorCheck = !colorCheck;
            }
            colorCheck = !colorCheck;
        }
        count = Math.min(count, 64 - count);
        min = Math.min(min, count);
    }
}
