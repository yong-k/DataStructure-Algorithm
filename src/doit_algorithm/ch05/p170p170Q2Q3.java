package doit_algorithm.ch05;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

// 실습 5-2 (유클리드 호제법, 최대공약수)
public class p170p170Q2Q3 {
    // x >= y
    static int gcd(int x, int y) {
        if (x < y) {
            int temp = x;
            x = y;
            y = temp;
        }

        if (y == 0)
            return x;
        else
            return gcd(y, x % y);
    }

    // p170-Q2
    static int gcd_noRecursive(int x, int y) {
        while (y != 0) {
            int result = x % y;
            x = y;
            y = result;
        }
        return x;
    }

    // p170-Q3
    static int gcdArray(int[] a) {
        // **배열의 요소가 1개일 수도 있으니까!
        int result = a[0];
        for (int i = 1; i <= a.length-1; i++) {
            if (i == 1)
                result = gcd(a[i-1], a[i]);
            else
                result = gcd(result, a[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        /*
        Scanner sc = new Scanner(System.in);
        System.out.print("x : ");
        int x = sc.nextInt();
        System.out.print("y : ");
        int y = sc.nextInt();

        System.out.printf("(재귀O)최대공약수 : %d\n", gcd(x, y));
        System.out.printf("(재귀X)최대공약수 : %d\n", gcd_noRecursive(x, y));
        */

        int[] a = {11, 55};
        System.out.printf("(배열)최대공약수 : %d\n", gcdArray(a));
    }
}
