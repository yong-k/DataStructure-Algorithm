package baekjoon_step.Step18_culmulativeSum;

import java.io.*;
import java.util.*;

public class B_2559 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        long sum = 0;
        long max = Long.MIN_VALUE;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());


        for (int i = 0; i <= N-K; i++) {
            sum = 0;
            for (int j = i; j < i+K; j++) {
                sum += arr[j];
            }
            max = Math.max(max, sum);
        }

        System.out.println(max);
    }
}
