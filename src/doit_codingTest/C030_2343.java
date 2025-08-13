package doit_codingTest;

import java.util.Scanner;

public class C030_2343 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] arr = new int[N];

        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();

            if (max < arr[i])
                max = arr[i];
            sum += arr[i];
        }

        int s = max;
        int e = sum;
        while (s <= e) {
            int mid = (s + e) / 2;
            int total = 0;
            int count = 0;
            for (int i = 0; i < N; i++) {
                if (total + arr[i] > mid) {
                    count++;
                    total = 0;
                }
                total += arr[i];
            }
            if (total > 0)
                count++;

            if (count > M) {
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }
        System.out.println(s);
    }
}
