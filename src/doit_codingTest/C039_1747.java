package doit_codingTest;

import java.util.Scanner;

public class C039_1747 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        // 2 ~ 10,000,000 사이 모든 소수 구함
        boolean[] primes = new boolean[10000001];
        for (int i = 2; i < primes.length; i++)
            primes[i] = true;
        for (int i = 2; i <= Math.sqrt(primes.length); i++) {
            if (!primes[i]) continue;
            for (int j = i + i; j < primes.length; j += i)
                primes[j] = false;
        }

        for (int i = N; i < primes.length; i++) {
            if (primes[i] && isPalindrome(i)) {
                System.out.println(i);
                break;
            }
        }
    }

    static boolean isPalindrome(int target) {
        char[] arr = String.valueOf(target).toCharArray();
        int s = 0;
        int e = arr.length - 1;
        while (s < e) {
            if (arr[s] != arr[e])
                return false;
            s++;
            e--;
        }
        return true;
    }
}
