package baekjoon_step.Step11_sorting;

import java.io.*;
import java.util.*;
public class B050_2108 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int sum = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }
        Arrays.sort(arr);

        //1 산술평균
        sb.append(Math.round((double)sum / N) + "\n");

        //2 중앙값
        sb.append(arr[N / 2] + "\n");

        //3 최빈값



        //4 범위
        sb.append(arr[N - 1] - arr[0] + "\n");

        System.out.println(sb);
    }
}
