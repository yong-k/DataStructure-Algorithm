package doit_algorithm.ch04;

import java.util.Scanner;

// 실습 4-4
public class p158p160Q5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        p148p160Q5 que = new p148p160Q5(64);    // 최대 64개를 인큐할 수 있는 큐

        while (true) {
            System.out.println("현재 데이터 수: " + que.size() + " / " + que.capacity());
            System.out.print("(1)인큐  (2)디큐  (3)피크  (4)덤프  (5) 프런트부터위치  (0)종료 : ");
            int menu = sc.nextInt();
            if (menu == 0) break;

            int x;
            switch (menu) {
                case 1: // 인큐
                    System.out.print("데이터: ");
                    x = sc.nextInt();
                    try {
                     que.enque(x);
                    } catch (p148p160Q5.OverflowIntQueueException e) {
                        System.out.println("큐 가득 참");
                    }
                    break;
                case 2: // 디큐
                    try {
                        x = que.deque();
                        System.out.println(x + "을/를 디큐함");
                    } catch (p148p160Q5.EmptyIntQueueException e) {
                        System.out.println("큐 비어있음");
                    }
                    break;
                case 3: // 피크
                    try {
                        x = que.peek();
                        System.out.println("피크 데이터 : " + x);
                    } catch (p148p160Q5.EmptyIntQueueException e) {
                        System.out.println("큐 비어있음");
                    }
                    break;
                case 4: // 덤프
                    que.dump();
                    break;
                case 5: // 프런트부터의 위치
                    x = que.search(sc.nextInt());
                    if (x == 0)
                        System.out.println("데이터 없음");
                    else
                        System.out.printf("데이터의 위치 front로부터 %d번째\n", x);
            }
        }
    }
}
