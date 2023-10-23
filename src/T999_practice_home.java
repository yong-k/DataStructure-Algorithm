import jdk.swing.interop.SwingInterOpUtils;

import java.io.*;
import java.util.*;

public class T999_practice_home {
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

        dp[0][RED] = cost[0][RED];
        dp[0][GREEN] = cost[0][GREEN];
        dp[0][BLUE] = cost[0][BLUE];

        System.out.println(Math.min(paintHouse(N - 1, RED), Math.min(paintHouse(N - 1, GREEN), paintHouse(N - 1, BLUE))));
    }

    static int paintHouse(int n, int color) {
        if (dp[n][color] == 0) {
            if (color == RED)
                dp[n][RED] = Math.min(paintHouse(n - 1, GREEN), paintHouse(n - 1, BLUE)) + cost[n][RED];
            else if (color == GREEN)
                dp[n][GREEN] = Math.min(paintHouse(n - 1, RED), paintHouse(n - 1, BLUE)) + cost[n][GREEN];
            else
                dp[n][BLUE] = Math.min(paintHouse(n - 1, RED), paintHouse(n - 1, GREEN)) + cost[n][BLUE];
        }
        return dp[n][color];
    }
}