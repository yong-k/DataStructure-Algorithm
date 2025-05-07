package doit_codingTest;

import java.util.Scanner;

public class C038_1456 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Long A = sc.nextLong();
        Long B = sc.nextLong();

        // 10(7) = 10000000
        boolean[] primes = new boolean[10000001];
        for (int i = 2; i < primes.length; i++)
            primes[i] = true;

        for (int i = 2; i <= Math.sqrt(primes.length); i++) {
            if (!primes[i]) continue;
            for (int j = i + i; j < primes.length; j += i)
                primes[j] = false;
        }

        int count = 0;
        for (int i = 2; i < primes.length; i++) {
            if (primes[i]) {
                long temp = i;
                while ((double)i * temp <= (double)B) {
                    if ((double)i * temp >= (double)A) {
                        count++;
                    }
                    temp *= i;
                }
            }
        }
        System.out.println(count);
    }
}
