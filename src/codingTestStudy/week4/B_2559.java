package codingTestStudy.week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_2559 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());   // 전체 날짜 수
        int K = Integer.parseInt(st.nextToken());   // 연속 날짜 수
        int[] prefixSum = new int[N + 1];           // 누적합 배열

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            prefixSum[i] = prefixSum[i - 1] + Integer.parseInt(st.nextToken());
        }
        
        // 배열 전체 돌면서, K개씩 누적합 계산하며, max값 업데이트
        int max = Integer.MIN_VALUE;
        for (int i = K; i <= N; i++) {
            max = Math.max(max, prefixSum[i] - prefixSum[i - K]);
        }
        System.out.println(max);
    }
}
