package doit_algorithm.ch03;

import java.util.Scanner;

public class p117Q5 {
    // 나
    /*
    static int binSearchX(int[] arr, int key) {
        int pl = 0;
        int pr = arr.length - 1;
        int pc;
        do {
            pc = (pl + pr) / 2;
            if (arr[pc] == key)
                break;
            else if (arr[pc] < key)
                pl = pc + 1;
            else
                pr = pc - 1;
        } while (pl <= pr);

        if (arr[pc] == key) {
            int idx = pc;
            while (true) {
                if (arr[--pc] == arr[idx])
                    idx--;
                else
                    return idx;
            }
        }
        return -1;
    }
    */
    // 답
    static int binSearchX(int[] arr, int key) {
        int pl = 0;
        int pr = arr.length - 1;
        int pc;
        do {
            pc = (pl + pr) / 2;
            if (arr[pc] == key) {
                // key와 같은 맨 앞의 요소 찾음
                for (; pc < pl; pc--)
                    if (arr[pc - 1] < key)
                        break;
                return pc;
            }
            else if (arr[pc] < key)
                pl = pc + 1;
            else
                pr = pc - 1;
        } while (pl <= pr);
        return -1;
    }

    public static void main (String[]args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("요솟수 : ");
        int n = sc.nextInt();
        int[] arr = new int[n];

        System.out.println("오름차순으로 입력하세요.");

        System.out.print("arr[0] : ");
        arr[0] = sc.nextInt();
        for (int i = 1; i < arr.length; i++) {
            do {
                System.out.printf("arr[%d] : ", i);
                arr[i] = sc.nextInt();
            } while (arr[i] < arr[i - 1]);
        }

        System.out.print("검색할 값: ");
        int key = sc.nextInt();
        int index = binSearchX(arr, key);

        if (index == -1)
            System.out.println("요소 존재 X");
        else
            System.out.printf("x[%d]에서 요소 발견\n", index);
    }

}
