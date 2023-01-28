package baekjoon_step.Step29_twoPointer;

import java.io.*;
import java.util.*;

public class B_1806 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        int start = 0;
        int end = 0;
        int sum = 0;
        int length = Integer.MAX_VALUE;
        while (end < N) {
            if (sum >= S) {
                sum -= arr[start];
                length = Math.min(end - start, length);
                start++;
            } else
                sum += arr[end++];
        }
        length = (length == Integer.MAX_VALUE) ? 0 : length;
        System.out.println(length);
    }
}
