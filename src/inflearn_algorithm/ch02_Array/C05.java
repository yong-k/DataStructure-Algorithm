package inflearn_algorithm.ch02_Array;

import java.io.*;
public class C05 {
    static boolean[] prime;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        prime = new boolean[n + 1];
        isPrime();
        int count = 0;
        for (boolean x : prime)
            if (!x) count++;
        System.out.println(count);
    }

    static void isPrime() {
        prime[0] = prime[1] = true;
        for (int i = 2; i <= Math.sqrt(prime.length); i++) {
            if (prime[i])
                continue;
            for (int j = i * i; j < prime.length; j += i)
                prime[j] = true;
        }
    }
}
