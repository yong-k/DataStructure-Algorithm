package baekjoon_step.Step29_twoPointer;

import java.io.*;
import java.util.*;

public class B_2470 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);

        int start = 0;
        int end = N - 1;
        int sum = 0;
        int sumAbs = 0;
        int minSum = Integer.MAX_VALUE;
        int liquid1 = 0;
        int liquid2 = 0;

        while (start < end) {
            sum = arr[start] + arr[end];
            sumAbs = Math.abs(sum);
            if (sumAbs < minSum) {
                minSum = sumAbs;
                liquid1 = arr[start];
                liquid2 = arr[end];
            }

            if (sum > 0) end--;
            else start++;
        }
        System.out.println(liquid1 + " " + liquid2);
    }
}
