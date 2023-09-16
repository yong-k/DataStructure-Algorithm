package codingTestStudy.week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class B_10811_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];

        for (int i = 0; i < N; i++)
            arr[i] = i + 1;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken()) - 1;
            int e = Integer.parseInt(st.nextToken()) - 1;
            for (int j = s, k = e; j <= ((s + e) / 2); j++, k--) {
                int temp = arr[j];
                arr[j] = arr[k];
                arr[k] = temp;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i : arr)
            sb.append(i).append(' ');
        System.out.println(sb);
    }
}
