package doit_algorithm.ch01;

import java.util.Scanner;

public class p40 {
    // Q15
    // 왼쪽 아래가 직각인 이등변 삼각형
    static void triangleLV(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++)
                System.out.print("*");
            System.out.println();
        }
    }
    // 왼쪽 위가 직각인 이등변 삼각형
    static void triangleLU(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = n; j > i; j--)
                System.out.print("*");
            System.out.println();
        }
    }
    // 오른쪽 위가 직각인 이등변 삼각형
    static void triangleRU(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j < i) System.out.print(" ");
                else System.out.print("*");
            }
            System.out.println();
        }
    }
    // 오른쪽 아래가 직각인 이등변 삼각형
    static void triangleRB(int n) {
        for (int i = n-1; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                if (j < i) System.out.print(" ");
                else System.out.print("*");
            }
            System.out.println();
        }
    }

    // Q16
    static void spira(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n*2-1; j++) {
                if (j <= n-i || j >= n+i) System.out.print(" ");
                else System.out.print("*");
            }
            System.out.println();
        }
    }

    // Q17
    static void npira(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n*2-1; j++) {
                if (j <= n-i || j >= n+i) System.out.print(" ");
                else System.out.print(i);
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("몇 단? : ");
        int n = sc.nextInt();
        //triangleLV(n);
        //triangleLU(n);
        //triangleRU(n);
        //triangleRB(n);
        //spira(n);
        npira(n);
    }
}
