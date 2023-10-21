package codingTestStudy.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_1920 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        // 이분탐색 위해 정렬
        Arrays.sort(arr);

        int M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int num = Integer.parseInt(st.nextToken());
            boolean isFind = false;
            int left = 0;
            int right = N - 1;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (arr[mid] == num) {
                    isFind = true;
                    break;
                } else if (arr[mid] < num) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

            if (isFind)
                sb.append(1).append('\n');
            else
                sb.append(0).append('\n');
        }
        System.out.print(sb);
    }
}
