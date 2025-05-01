package doit_codingTest;

import java.util.Scanner;
import java.util.Arrays;

public class C008_1253 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);

        int count = 0;
        for (int i = 0; i < N; i++) {
            int find = arr[i];
            int s = 0;
            int e = N - 1;
            while (s < e) {
                int sum = arr[s] + arr[e];
                if (sum == find) {
                    if (s != i && e != i) {
                        count++;
                        break;
                    } else if (s == i) {
                        s++;
                    } else {
                        e--;
                    }
                } else if (sum < find) {
                    s++;
                } else {
                    e--;
                }
            }
        }
        System.out.println(count);
    }
}
