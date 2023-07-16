package codingTestStudy.week1;

import java.util.*;
public class B_10811 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int[] arr = new int[N];

        for (int i = 0; i < N; i++)
            arr[i] = i + 1;

        for (int i = 0; i < M; i++) {
            int s = sc.nextInt() - 1;
            int e = sc.nextInt() - 1;
            for (int j = s, k = e; j <= ((s + e) / 2); j++, k--) {
                int temp = arr[j];
                arr[j] = arr[k];
                arr[k] = temp;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i : arr)
            sb.append(i).append(' ');
        System.out.println(sb);
    }
}
