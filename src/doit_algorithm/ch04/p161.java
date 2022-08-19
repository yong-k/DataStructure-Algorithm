package doit_algorithm.ch04;

import java.util.Scanner;

public class p161 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int N = 10;
        int[] a = new int[N];
        int cnt = 0;    // 입력 받은 개수
        int retry;

        System.out.println("정수를 입력하세요.");
        do {
            System.out.printf("%d번째 정수 : ", cnt + 1);
            a[cnt++ % N] = sc.nextInt();
            //-- 『cnt++ % N』 : 링 버퍼(배열)에 순환하며 저장되고 있음

            System.out.print("계속? (예.1/아니오.0) : ");
            retry = sc.nextInt();
        } while (retry == 1);

        int i = cnt - N;    // 최근 입력한 N개 중 첫번째 번호 구함
        if (i < 0) i = 0;
        for ( ; i < cnt; i++)
            System.out.printf("%2d번째 정수 = %d\n", i + 1, a[i % N]);
    }
}
