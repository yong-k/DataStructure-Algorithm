package tony_git.binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_10815 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        // 이분탐색을 위한 정렬
        Arrays.sort(arr);

        int M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int key = Integer.parseInt(st.nextToken());
            boolean flag = false;
            int left = 0;
            int right = arr.length - 1;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (arr[mid] == key) {
                    flag = true;
                    break;
                } else if (arr[mid] < key)
                    left = mid + 1;
                else
                    right = mid - 1;
            }
            if (flag)
                sb.append(1).append(' ');
            else
                sb.append(0).append(' ');
        }
        System.out.println(sb);
    }
}
