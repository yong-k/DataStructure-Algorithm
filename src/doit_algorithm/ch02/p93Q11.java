package doit_algorithm.ch02;

import java.util.Scanner;

// Q11
public class p93Q11 {
    int y, m, d;
    static int[][] mdays = {
            { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 }, // 평년
            { 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 }, // 윤년
    };

    static int isLeap(int year) {
        return (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) ? 1 : 0;
    }

    p93Q11(int y, int m, int d) {
        this.y = y;
        this.m = m;
        this.d = d;
    }

    p93Q11 after(int n) {
        p93Q11 ymd = new p93Q11(this.y, this.m, this.d);
        if (n < 0)
            return before(-n);
        ymd.d += n;

        while (ymd.d > mdays[isLeap(ymd.y)][ymd.m - 1]) {
            ymd.d -= mdays[isLeap(ymd.y)][ymd.m - 1];
            if (++ymd.m > 12) {
                ymd.y++;
                ymd.m = 1;
            }
        }
        return ymd;
    }

    p93Q11 before(int n) {
        p93Q11 ymd = new p93Q11(this.y, this.m, this.d);
        if (n < 0)
            return after(-n);

        ymd.d -= n;

        while(ymd.d < 1) {
            if (--ymd.m < 1) {
                ymd.y--;
                ymd.m = 12;
            }
            ymd.d += mdays[isLeap(ymd.y)][ymd.m - 1];
        }
        return ymd;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("날짜 입력");
        System.out.print("year: ");
        int y = sc.nextInt();
        System.out.print("month: ");
        int m = sc.nextInt();
        System.out.print("day: ");
        int d = sc.nextInt();

        p93Q11 date = new p93Q11(y, m, d);

        System.out.print("몇 일 앞/뒤의 날짜를 구할까요? : ");
        int n = sc.nextInt();
        p93Q11 d1 = date.after(n);
        System.out.printf("%d일 뒤의 날짜는 %d년 %d월 %d일입니다.\n", n, d1.y, d1.m, d1.d);

        p93Q11 d2 = date.before(n);
        System.out.printf("%d일 앞의 날짜는 %d년 %d월 %d일입니다.\n", n, d2.y, d2.m, d2.d);



    }


}
