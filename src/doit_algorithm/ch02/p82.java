package doit_algorithm.ch02;

import java.util.Scanner;

//실습 2-13
public class p82 {
    static int[][] mdays = {
            { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 },     // 평년
            { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 }      // 윤년
    };

    static int isLeap(int year) {
        return (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) ? 1 : 0;
    }

    static int dayOfYear(int year, int month, int day) {
        int isLeap = isLeap(year);
        int days = day;     // 일 수
        for (int i = 1; i < month; i++)
            days += mdays[isLeap][i - 1];
        return days;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int retry;

        System.out.println("그 해 경과 일 수를 구합니다.");
        do {
            System.out.print("년 : ");
            int year = sc.nextInt();
            System.out.print("월 : ");
            int month = sc.nextInt();
            System.out.print("일 : ");
            int day = sc.nextInt();

            System.out.printf("그 해 %d일째입니다.\n", dayOfYear(year, month, day));

            System.out.print("한 번 더 할까요? (1.예/0.아니오) : ");
            retry = sc.nextInt();
        } while (retry == 1);
    }
}
