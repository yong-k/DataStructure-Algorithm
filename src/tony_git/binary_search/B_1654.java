package tony_git.binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_1654 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        long[] arr = new long[K];
        for (int i = 0; i < K; i++)
            arr[i] = Integer.parseInt(br.readLine());

        Arrays.sort(arr);

        long left = 1;
        long right = arr[K - 1];
        while (left <= right) {
            long mid = (left + right) / 2;
            long sum = 0;
            for (int i = 0; i < K; i++)
                sum += arr[i] / mid;

            if (sum < N)
                right = mid - 1;
            else
                left = mid + 1;
        }
        System.out.println(right);
    }
}
