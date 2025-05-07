package doit_codingTest;

import java.util.Scanner;

public class C032_11047 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] arr = new int[N];

        for (int i = 0; i < N; i++)
            arr[i] = sc.nextInt();

        int count = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            int coin = arr[i];
            count += K / coin;
            K %= coin;
        }
        System.out.println(count);
    }
}
