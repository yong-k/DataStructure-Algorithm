package inflearn_algorithm.ch02_Array;

import java.io.*;
import java.util.*;
public class C08 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] score = new int[n];
        int[] grade = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            score[i] = Integer.parseInt(st.nextToken());
            grade[i] = 1;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                if (score[i] > score[j])
                    grade[j]++;
            }
        }
        for (int x : grade)
            System.out.print(x + " ");
    }
}
