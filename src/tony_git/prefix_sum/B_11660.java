package tony_git.prefix_sum;

import java.util.Scanner;

public class B_11660 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[][] arr = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                arr[i][j] = arr[i][j - 1] + sc.nextInt();
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();

            int sum = 0;
            for (int j = x1; j <= x2; j++) {
                sum += arr[j][y2] - arr[j][y1 - 1];
            }
            sb.append(sum).append('\n');
        }
        System.out.println(sb);
    }
}
