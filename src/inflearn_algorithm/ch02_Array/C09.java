package inflearn_algorithm.ch02_Array;

import java.io.*;
import java.util.*;
public class C09 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n + 1][n + 1];
        int sum = 0;
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                arr[i][n] += arr[i][j];
                arr[n][j] += arr[i][j];
                if (i == j)
                    arr[n][n] += arr[i][j];
                if (i + j == n - 1)
                    sum += arr[i][j];
            }
        }

        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i][n] > max)
                max = arr[i][n];
            if (arr[n][i] > max)
                max = arr[n][i];
        }
        if (sum > max)
            max = sum;
        System.out.println(max);
    }
}
