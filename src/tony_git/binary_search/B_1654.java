package tony_git.binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B_1654 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());   // 이미 가지고 있는 랜선 개수
        int N = Integer.parseInt(st.nextToken());   // 필요한 랜선 개수
        int[] arr = new int[K];

        long max = 0;
        for (int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, arr[i]);
        }

        long left = 1;
        long right = max;
        long answer = 0;
        while (left <= right) {
            long mid = (left + right) / 2;
            long count = 0;
            for (int i = 0; i < arr.length; i++)
                count += arr[i] / mid;

            if (count >= N) {
                answer = Math.max(answer, mid);
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        System.out.println(answer);
    }
}
