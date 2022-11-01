package inflearn_algorithm.ch02_Array;

import java.io.*;
import java.util.*;
public class C10 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n+2][n+2];
        StringTokenizer st;
        for (int i = 1; i < arr.length - 1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < arr[i].length - 1; j++)
                arr[i][j] = Integer.parseInt(st.nextToken());
        }

        int count = 0;
        for (int i = 1; i < arr.length - 1; i++) {
            for (int j = 1; j < arr.length - 1; j++) {
                if (arr[i][j] > arr[i-1][j] && arr[i][j] > arr[i+1][j]
                 && arr[i][j] > arr[i][j-1] && arr[i][j] > arr[i][j+1])
                    count++;
            }
        }
        System.out.println(count);
    }
}
