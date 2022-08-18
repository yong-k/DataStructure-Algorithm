package doit_algorithm.ch03;

import java.util.Scanner;

public class p111 {
    static int binSearch(int[] arr, int n, int key) {
        int pl = 0;         // 검색 범위의 첫 인덱스
        int pr = n - 1;     // 검색 범위의 끝 인덱스

        do {
            int pc = (pl + pr) / 2;     // 중앙 요소의 인덱스
            if (arr[pc] == key)
                return pc;
            else if (arr[pc] < key)
                pl = pc + 1;
            else
                pr = pc - 1;
        } while (pl <= pr);

        return -1;
    }

    public static void main(String[] args) {
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
            } while (arr[i] < arr[i-1]);
        }

        System.out.print("검색할 값: ");
        int key = sc.nextInt();

        int index = binSearch(arr, n, key);

        if (index == -1)
            System.out.println("요소 존재 X");
        else
            System.out.printf("x[%d]에서 요소 발견\n", index);

    }
}

