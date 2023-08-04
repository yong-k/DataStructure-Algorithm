package codingTestStudy.week3;

// https://st-lab.tistory.com/128

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_1149 {
    final static int RED = 0;
    final static int GREEN = 1;
    final static int BLUE = 2;
    static int[][] cost;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        cost = new int[N][3];
        dp = new int[N][3];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            cost[i][RED] = Integer.parseInt(st.nextToken());
            cost[i][GREEN] = Integer.parseInt(st.nextToken());
            cost[i][BLUE] = Integer.parseInt(st.nextToken());
        }

        // 첫번째 집은 첫번째 값으로 초기화
        dp[0][RED] = cost[0][RED];
        dp[0][GREEN] = cost[0][GREEN];
        dp[0][BLUE] = cost[0][BLUE];

        System.out.println(Math.min(paintHouse(N - 1, RED), Math.min(paintHouse(N - 1, GREEN), paintHouse(N - 1, BLUE))));
    }

    static int paintHouse(int N, int color) {
        // 탐색하지 않은 집이라면
        if (dp[N][color] == 0) {
            if (color == RED)
                dp[N][RED] = Math.min(paintHouse(N - 1, GREEN), paintHouse(N - 1, BLUE)) + cost[N][RED];
            else if (color == GREEN)
                dp[N][GREEN] = Math.min(paintHouse(N - 1, RED), paintHouse(N - 1, BLUE)) + cost[N][GREEN];
            else
                dp[N][BLUE] = Math.min(paintHouse(N - 1, RED), paintHouse(N - 1, GREEN)) + cost[N][BLUE];
        }
        return dp[N][color];
    }
}
