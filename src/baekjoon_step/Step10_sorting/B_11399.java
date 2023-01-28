package baekjoon_step.Step10_sorting;

import java.io.*;
import java.util.*;

public class B_11399 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);
        int sum = 0;
        for (int i = 0; i < N; i++)
            for (int j = 0; j <= i; j++)
                sum += arr[j];

        System.out.println(sum);
    }
}
