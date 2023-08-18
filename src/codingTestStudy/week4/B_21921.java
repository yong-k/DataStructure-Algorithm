package codingTestStudy.week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_21921 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        int[] prefixSum = new int[N + 1];
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++)
            prefixSum[i] = prefixSum[i - 1] + Integer.parseInt(st.nextToken());

        // X일 동안 방문자 최댓값 찾기
        int max = Integer.MIN_VALUE;
        int[] prefixSumX = new int[prefixSum.length];   // X일 동안의 누적합 저장
        for (int i = X, j = 0; i <= N; i++, j++) {
            max = Math.max(max, prefixSum[i] - prefixSum[j]);
            prefixSumX[i] = prefixSum[i] - prefixSum[j];
        }

        StringBuilder sb = new StringBuilder();
        if (max == 0) {
            sb.append("SAD");
        } else {
            int count = 0;
            for (int i = X; i < prefixSumX.length; i++) {
                if (prefixSumX[i] == max)
                    count++;
            }
            sb.append(max).append('\n');
            sb.append(count).append('\n');
        }
        System.out.println(sb);
    }
}
