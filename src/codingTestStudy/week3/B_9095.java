package codingTestStudy.week3;

// https://dnf-lover.tistory.com/entry/%EB%B0%B1%EC%A4%80-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-9095%EB%B2%88-1-2-3-%EB%8D%94%ED%95%98%EA%B8%B0-DP-%EB%8B%A4%EC%9D%B4%EB%82%98%EB%AF%B9-%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%B0%8D-JAVA

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_9095 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        int[] dp = new int[11];     // 11까지 들어옴
        dp[0] = 0;
        dp[1] = 1;  // 1
        dp[2] = 2;  // 1+1, 2
        dp[3] = 4;  // 1+1+1, 1+2, 2+1, 3

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            for (int j = 4; j <= n; j++)
                dp[j] = dp[j - 1] + dp[j - 2] + dp[j - 3];
            sb.append(dp[n]).append('\n');
        }
        System.out.print(sb);
    }
}
