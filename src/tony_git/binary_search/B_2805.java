package tony_git.binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_2805 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());   // 나무의 수
        int M = Integer.parseInt(st.nextToken());   // 나무의 길이
        int[] tree = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            tree[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(tree);

        int min = 0;
        int max = tree[N - 1];
        while (min <= max) {
            int mid = (min + max) / 2;
            long sum = 0;
            for (int x : tree) {
                // 잘린 나무가 0보다 작으면 더하지 않는다.
                if (x - mid > 0)
                    sum += x - mid;
            }

            /*
            * 자른 나무 길이 합이 M보다 작으면, max(상한) 낮춰야 함
            * → max = mid - 1
            * */
            if (sum < M)
                max = mid - 1;
            else
                min = mid + 1;
        }
        System.out.println(max);
    }
}
