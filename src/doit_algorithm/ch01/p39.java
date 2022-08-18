package doit_algorithm.ch01;

import java.util.Scanner;

public class p39 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("몇 단 삼각형입니까? : ");
        int n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i ; j++)
                System.out.print("*");
            System.out.println();
        }
    }
}
