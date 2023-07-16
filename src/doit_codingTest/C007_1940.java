package doit_codingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Arrays;
import java.util.StringTokenizer;

// 백준 1940
/*
6
9
2 7 4 1 5 3
*/
public class C007_1940 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++)
            arr[i] = sc.nextInt();

        Arrays.sort(arr);

        int answer = 0;
        int s = 0;
        int e = arr.length - 1;
        while (s < e) {
            int sum = arr[s] + arr[e];
            if (sum == M) {
                answer++;
                s++;
                e--;
            } else if (sum < M) {
                s++;
            } else {
                e--;
            }
        }

        System.out.println(answer);
    }
}
