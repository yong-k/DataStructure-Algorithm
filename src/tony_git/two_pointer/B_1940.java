package tony_git.two_pointer;

import java.util.*;

public class B_1940 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);

        // 1 2 3 4 5 7
        int count = 0;
        int s = 0;
        int e = N - 1;
        while (s < e) {
            int sum = arr[s] + arr[e];
            if (sum == M) {
                count++;
                s++;
                e--;
            } else if (sum < M) {
                s++;
            } else {
                e--;
            }
        }
        System.out.println(count);
    }
}
