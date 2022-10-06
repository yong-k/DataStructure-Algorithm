package doit_codingTest;

// 백준 1546

import java.util.Scanner;

public class C002_1546 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        int max = 0;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (max < arr[i]) max = arr[i];
            sum += arr[i];
        }

        System.out.println((double)sum / max * 100 / n);
    }
}
