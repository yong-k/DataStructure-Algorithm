package doit_algorithm.ch02;

import java.util.Scanner;

public class p70 {
    static int cardConv(int x, int r, char[] d) {
        int digits = 0;
        String dchar = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";

        System.out.printf("%d|%6d\n", r, x);
        System.out.println(" + -------");
        do {
            d[digits] = dchar.charAt(x % r);
            x /= r;

            if (x != 0) {
                System.out.printf("%d|%6d ... %c\n", r, x, d[digits++]);
                System.out.println(" + -------");
            }
            else
                System.out.printf("%8d ... %c\n", x, d[digits++]);
        } while (x != 0);

        // 배열의 앞쪽에 윗자리를 넣어두게끔(Q6)
        // → 배열 완성된 후에, 역순으로 정렬하는 방법 사용
        char temp;
        for (int i = 0; i < digits / 2; i++) {
            temp = d[i];
            d[i] = d[digits - 1 - i];
            d[digits - 1 - i] = temp;
        }
        return digits;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num;    // 변환하는 정수
        int cd;     // 기수
        int digits; // 변환 후의 자릿수
        int retry;  // 다시 한 번?
        char[] d = new char[32];

        System.out.println("10진수를 기수 변환합니다.");
        do {
            do {
                System.out.print("변환하는 음이 아닌 정수 : ");
                num = sc.nextInt();
            } while (num < 0);

            do {
                System.out.print("어떤 진수로 변환할까요? (2~36) : ");
                cd = sc.nextInt();
            } while (cd < 2 || cd > 36);

            digits = cardConv(num, cd, d);
            System.out.printf("%d진수로는 ", cd);
            for (int i = 0; i < digits; i++)
                System.out.print(d[i]);
            System.out.println("입니다.");

            System.out.print("한 번 더 할까요? (1:예/0.아니오) : ");
            retry = sc.nextInt();
        } while (retry == 1);
    }
}
