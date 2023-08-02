package codingTestStudy.week3;

// https://st-lab.tistory.com/133

import java.io.*;
public class B_1463 {
    static Integer[] dp;    // 메모이제이션 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        dp = new Integer[N + 1];
        System.out.println(recur(N));
    }

    static int recur(int N) {
        dp[0] = dp[1] = 0;

        // 이전 재귀호출 최솟값에 1을 더함
        if (dp[N] == null) {
            if (N % 3 == 0 && N % 2 == 0)
                dp[N] = Math.min(recur(N / 3), Math.min(recur(N / 2), recur(N - 1))) + 1;
            else if (N % 3 == 0)
                dp[N] = Math.min(recur(N / 3), recur(N - 1)) + 1;
            else if (N % 2 == 0)
                dp[N] = Math.min(recur(N / 2), recur(N - 1)) + 1;
            else
                dp[N] = recur(N - 1) + 1;
        }
        return dp[N];
    }
}
