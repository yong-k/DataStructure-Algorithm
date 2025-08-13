package study_250813.greedy;

import java.util.Arrays;
import java.util.Scanner;

/*
이코테 - 큰 수의 법칙
5 8 3
2 4 5 4 6
==> 46

5 7 2
3 4 3 4 3
==> 28
*/
public class G01_this {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int K = sc.nextInt();

        int[] arr = new int[N];
        for (int i = 0; i < N; i++)
            arr[i] = sc.nextInt();

        Arrays.sort(arr);
        int num1 = arr[N - 1];
        int num2 = arr[N - 2];

        // num1(가장 큰 수)가 더해지는 횟수
        int count = (M / (K + 1)) * K;
        count += M % (K + 1);

        int result = 0;
        result += num1 * count;
        result += num2 * (M - count);
        System.out.println(result);
    }
}
