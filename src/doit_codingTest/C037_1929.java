package doit_codingTest;

import java.util.Scanner;

public class C037_1929 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();
        boolean[] primes = new boolean[N + 1];

        for (int i = 2; i <= N; i++)
            primes[i] = true;

        for (int i = 2; i <= Math.sqrt(N); i++) {
            if (!primes[i]) continue;
            for (int j = i + i; j <= N; j += i)
                primes[j] = false;
        }

        for (int i = M; i <= N; i++) {
            if (primes[i])
                System.out.println(i);
        }
    }
}
