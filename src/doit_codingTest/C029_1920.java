package doit_codingTest;

import java.util.Arrays;
import java.util.Scanner;

public class C029_1920 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];
        for(int i = 0; i < N; i++)
            arr[i] = sc.nextInt();

        Arrays.sort(arr);

        int M = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int target = sc.nextInt();
            int s = 0;
            int e = N - 1;
            boolean flag = false;
            while (s <= e) {
                int mid = (s + e) / 2;
                if (arr[mid] == target) {
                    flag = true;
                    break;
                } else if (arr[mid] < target) {
                    s = mid + 1;
                } else {
                    e = mid - 1;
                }
            }
            if (flag) {
                sb.append(1).append('\n');
            } else {
                sb.append(0).append('\n');
            }
        }
        System.out.println(sb);
    }
}
