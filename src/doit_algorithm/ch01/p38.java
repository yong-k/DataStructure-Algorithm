package doit_algorithm.ch01;

import java.util.Scanner;

public class p38 {
    static void Q12() {
        System.out.println("   |   1   2   3   4   5   6   7   8   9");
        System.out.println("---+--------------------------------------");
        for (int i = 1; i <= 9; i++) {
            System.out.printf("%2d |", i);
            for (int j = 1; j <= 9; j++)
                System.out.printf("%4d", i*j);
            System.out.println();
        }
    }
    static void Q13() {
        System.out.println("   |   1   2   3   4   5   6   7   8   9");
        System.out.println("---+--------------------------------------");
        for (int i = 1; i <= 9; i++) {
            System.out.printf("%2d |", i);
            for (int j = 1; j <= 9; j++)
                System.out.printf("%4d", j+i);
            System.out.println();
        }
    }
    static void Q14() {
        Scanner sc = new Scanner(System.in);
        System.out.print("단 수 : ");
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                System.out.print("*");
            System.out.println();
        }
    }
    public static void main(String[] args) {
        //Q12();
        //Q13();
        Q14();
    }
}
