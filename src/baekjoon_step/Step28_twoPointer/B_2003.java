package baekjoon_step.Step28_twoPointer;

import java.io.*;
import java.util.*;

public class B_2003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        int left = 0;
        int right = 0;
        int count = 0;
        int sum = 0;
        while (right < N) {
            if (sum >= M)
                sum -= arr[left++];
            else
                sum += arr[right++];

            if (sum == M) count++;
        }
        System.out.println(count);
    }
}
