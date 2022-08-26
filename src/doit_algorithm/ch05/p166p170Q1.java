package doit_algorithm.ch05;

import java.util.Scanner;

// 실습 5-1 (팩토리얼)
public class p166p170Q1 {
    static int factorial(int n) {
        if (n > 0)
            return n * factorial(n - 1);
        else
            return 1;
    }

    // p170-Q1
    static int factorial_noRecursive(int n) {
        int result = 1;
        for (int i = n; i > 0; i--)
            result *= i;
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("정수 입력: ");
        int n = sc.nextInt();
        System.out.printf("(재귀O) %d! = %d\n", n, factorial(n));
        System.out.printf("(재귀X) %d! = %d\n", n, factorial_noRecursive(n));
    }
}
