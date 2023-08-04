package codingTestStudy.week3;

// https://fbtmdwhd33.tistory.com/76

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_9465 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int k = 0; k < T; k++) {
            int n = Integer.parseInt(br.readLine());
            int[][] cost = new int[2][n + 1];
            int[][] dp = new int[2][n + 1];

            for (int i = 0; i < 2; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 1; j <= n; j++)
                    cost[i][j] = Integer.parseInt(st.nextToken());
            }

            // 초기화
            dp[0][1] = cost[0][1];
            dp[1][1] = cost[1][1];

            for (int i = 2; i <= n; i++) {
                dp[0][i] = Math.max(dp[1][i - 1], dp[1][i - 2]) + cost[0][i];
                dp[1][i] = Math.max(dp[0][i - 1], dp[0][i - 2]) + cost[1][i];
            }
            sb.append(Math.max(dp[0][n], dp[1][n])).append('\n');
        }
        System.out.print(sb);
    }
}


