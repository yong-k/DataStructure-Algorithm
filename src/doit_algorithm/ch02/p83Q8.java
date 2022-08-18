package doit_algorithm.ch02;

import java.util.Scanner;

// Q8
public class p83Q8 {
    static int[][] mdays = {
            { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 },     // 평년
            { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 }      // 윤년
    };

    static int isLeap(int year) {
        return (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) ? 1 : 0;
    }

    static int dayOfYear(int year, int month, int day) {
        int isLeap = isLeap(year);
        month -= 2;
        while (month >= 0) {
            day += mdays[isLeap][month--];
        }
        return day;
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
        } while(retry == 1);
    }
}
