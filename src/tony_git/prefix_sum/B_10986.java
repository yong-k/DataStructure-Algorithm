package tony_git.prefix_sum;

import java.util.Scanner;

public class B_10986 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        long[] sums = new long[N];
        sums[0] = sc.nextInt();
        for (int i = 1; i < N; i++) {
            sums[i] = sums[i - 1] + sc.nextInt();
        }

        long[] mods = new long[M];
        for (int i = 0; i < N; i++) {
            mods[(int)(sums[i] % M)]++;
        }

        long result = mods[0];
        for (long mod : mods) {
            if (mod > 1) {
                // nC2 = (n-1)n / 2
                result += (mod - 1) * mod / 2;
            }
        }
        System.out.println(result);
    }
}
