package codingTestStudy.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_2579 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] stair = new int[n + 1];
        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++)
            stair[i] = Integer.parseInt(br.readLine());

        /*
        * 계단은 한 번에 한 계단, 두 계단씩 오를 수 있음
        * 연속된 3개 못 밟음
        * n-3 n-2 n-1 n
        * 1) n-3>n-1>n
        * 2) n-2>n
        * dp[n] = Math.max(dp[n-3] + stair[n-1], dp[n-2]) + stair[n];
        * */

        // 초기화
        dp[1] = stair[1];

        // n이 1일 경우 예외 처리
        if (n >= 2)
            dp[2] = stair[1] + stair[2];

        for (int i = 3; i <= n; i++)
            dp[i] = Math.max(dp[i - 3] + stair[i - 1], dp[i - 2]) + stair[i];

        System.out.println(dp[n]);
    }
}
