package baekjoon_step.Step12_bruteForce;

import java.io.*;
import java.util.*;
public class B042_2798 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        int result = solution(arr, N, M);
        System.out.println(result);
    }

    static int solution(int[] arr, int N, int M) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N - 2; i++) {
            for (int j = i + 1; j < N - 1; j++) {
                for (int k = j + 1; k < N; k++) {
                    sum = arr[i] + arr[j] + arr[k];

                    if (sum == M)
                        return sum;

                    if (sum > max && sum < M)
                        max = sum;
                }
            }
        }
        return max;
    }
}
