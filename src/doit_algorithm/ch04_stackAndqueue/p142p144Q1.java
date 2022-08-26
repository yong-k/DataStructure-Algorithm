package doit_algorithm.ch04_stackAndqueue;

import java.util.Scanner;

public class p142p144Q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        p136 stack = new p136(64);  // 최대 64개를 푸시할 수 있는 스택

        while (true) {
            System.out.println("현재 데이터 수 : " + stack.size() + " / " + stack.capacity());
            System.out.print("(1)푸시  (2)팝  (3)피크  (4)덤프  " +
                    "(5)데이터위치찾기  (6)비어있음?  (7)꽉차있음?  (8)초기화  (9)종료 : ");
            int menu = sc.nextInt();
            if (menu == 0) break;

            int x;
            switch (menu) {
                case 1: // 푸시
                    System.out.print("데이터 : ");
                    x = sc.nextInt();
                    try {
                        stack.push(x);
                        System.out.println(x + "을/를 push함");
                    } catch (p136.OverflowIntStackException e) {
                        System.out.println("스택이 가득 참");
                    }
                    break;
                case 2: // 팝
                    try {
                        x = stack.pop();
                        System.out.println(x + "을/를 pop함");
                    } catch (p136.EmptyIntStackException e) {
                        System.out.println("스택 비어있음");
                    }
                    break;
                case 3: // 피크
                    try {
                        x = stack.peek();
                        System.out.println(x + "을/를 peek함");
                    } catch (p136.EmptyIntStackException e) {
                        System.out.println("스택 비어있음");
                    }
                    break;
                case 4: // 덤프
                    stack.dump();
                    break;
                case 5: // indexOf()
                    System.out.print("위치 찾을 데이터: ");
                    x = sc.nextInt();
                    int idx = stack.indexOf(x);
                    if (idx == -1)
                        System.out.println("데이터 없음");
                    else
                        System.out.println("데이터 위치: " + idx);
                    break;
                case 6: // isEmpty()
                    if (stack.isEmpty())
                        System.out.println("스택 비었음");
                    else
                        System.out.printf("%d개 들어있음\n", stack.size());
                    break;
                case 7: // isFull()
                    if (stack.isFull())
                        System.out.println("스택 가득 참");
                    System.out.printf("공간 %d 남아있음\n", stack.capacity()-stack.size());
                    break;
                case 8: // clear()
                    System.out.println("스택을 초기화합니다.");
                    stack.clear();
                    System.out.println("초기화 완료!");
                    break;
            }
        }
    }
}
