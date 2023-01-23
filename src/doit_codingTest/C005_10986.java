package doit_codingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

// 백준 10986
public class C005_10986 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        long[] sum = new long[N];
        long[] result = new long[M];
        long count = 0;

        st = new StringTokenizer(br.readLine());
        sum[0] = Integer.parseInt(st.nextToken());
        for (int i = 1; i < N; i++)
            sum[i] = Integer.parseInt(st.nextToken()) + sum[i - 1];

        for (int i = 0; i < N; i++) {
            int remainder = (int)(sum[i] % M);
            if (remainder == 0) count++;
            result[remainder]++;
        }

        for (int i = 0; i < M; i++)
            if (result[i] > 1)
                count += result[i] * (result[i] - 1) / 2;

        System.out.println(count);
    }
}
