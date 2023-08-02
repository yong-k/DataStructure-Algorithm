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

        // 배열 정렬
        Arrays.sort(arr);

        int M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        for (int k = 0; k < M; k++) {
            int find = Integer.parseInt(st.nextToken());
            int left = 0;
            int right = N - 1;
            //int mid = (left + right) / 2;     //-- 여기에 두면 XXXXXX
            boolean flag = false;
            while (left <= right) {
                int mid = (left + right) / 2;   // 계속 update 해줘야함
                if (arr[mid] == find) {
                    flag = true;
                    break;
                } else if (arr[mid] < find) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            if (flag)
                sb.append(1).append('\n');
            else
                sb.append(0).append('\n');
        }
        System.out.print(sb);
    }
}
