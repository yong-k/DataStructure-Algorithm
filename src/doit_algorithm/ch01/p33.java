package doit_algorithm.ch01;

import java.util.Scanner;

public class p33 {
    // Q10
    static void subtract() {
        Scanner sc = new Scanner(System.in);
        System.out.print("a의 값: ");
        int a = sc.nextInt();
        System.out.print("b의 값: ");
        int b = sc.nextInt();

        while (b <= a) {
            System.out.println("a보다 큰 값을 입력하세요!");
            System.out.print("b의 값: ");
            b = sc.nextInt();
        }

        System.out.printf("b - a는 %d입니다.\n", b-a);
    }

    // Q11
    static void length() {
        Scanner sc = new Scanner(System.in);
        System.out.print("양의 정수 입력: ");
        int n = sc.nextInt();
        /*
        n/(10의 제곱수) 했을 때, (10의 제곱수)보다 몫 작게 나오면 stop
        1122
        1) 1122 / 10   = 112
        2) 1122 / 100  = 12
        3) 1122 / 1000 = 1  => 1000 = 10의 3제곱 => 3 + 1 = 4자리수
        */

        //그냥 문자로 바꿔서 length() 세면 될듯? ㅋ,,,
        // Integer.toString()
        String str = Integer.toString(n);
        int length = str.length();
        System.out.printf("그 수는 %d자리입니다.\n", length);
    }

    public static void main(String[] args) {
        length();
    }
}
