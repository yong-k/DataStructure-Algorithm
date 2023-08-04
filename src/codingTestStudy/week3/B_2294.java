package codingTestStudy.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_2294 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());   // 동전 종류
        int k = Integer.parseInt(st.nextToken());   // 합
        int[] arr = new int[n];
        int[] dp = new int[k + 1];

        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(br.readLine());

        dp[0] = 0;
        for (int i = 1; i <= k; i++)
            dp[i] = Integer.MAX_VALUE - 1;

        // 동전마다 돌면서, 만들 수 있는 개수 갱신해줌
        for (int i = 0; i < n; i++) {
            for (int j = arr[i]; j <= k; j++) {
                dp[j] = Math.min(dp[j], dp[j - arr[i]] + 1);
            }
        }
        System.out.println(dp[k] == Integer.MAX_VALUE - 1 ? -1 : dp[k]);
    }
}
