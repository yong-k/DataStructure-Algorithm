package doit_algorithm.ch05;

import java.util.Scanner;

// 실습 5-6 (하노이의 탑)
public class p180p182Q6 {
    // no개의 원반을 x번 기둥에서 y번 기둥으로 옮김
    static void move(int no, int x, int y) {
        if (no > 1)
            move(no - 1, x, 6 - x - y);

        System.out.printf("원반[%d]을 %d기둥에서 %d기둥으로 옮김\n", no, x, y);

        // Q6 ---------------------------------------------------------------------------------
        // 나
        /*
        char charX, charY;
        if (x == 1) charX = 'A';
        else if (x == 2) charX = 'B';
        else charX = 'C';
        if (y == 1) charY = 'A';
        else if (y == 2) charY = 'B';
        else charY = 'C';
        System.out.printf("원반[%d]을 %c기둥에서 %c기둥으로 옮김\n", no, charX, charY);
        */

        // 답 (배열 사용하면 됨)
        /*
        char[] name = {'A', 'B', 'C'};
        System.out.printf("원반[%d]을 %c기둥에서 %c기둥으로 옮김\n", no, name[x-1], name[y-1]);
        */
        // --------------------------------------------------------------------------------- Q6

        if (no > 1)
            move(no - 1, 6 - x - y, y);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("원반 개수: ");
        int no = sc.nextInt();
        move(no, 1, 3);
    }
}
