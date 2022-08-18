package doit_algorithm.ch03;

import java.util.Scanner;

// 실습 3-3 (p115-Q1)
public class p105_p115Q1 {
    static int seqSearch(int[] arr, int n, int key) {
        arr[n] = key;
        int i = 0;
        for (i = 0; i < n; i++)
            if (arr[i] == key)
                break;
        return i == n ? -1 : i;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("요솟수: ");
        int n = sc.nextInt();
        int[] arr = new int[n + 1];

        for (int i = 0; i < n; i++) {
            System.out.print("arr[" + i + "] : ");
            arr[i] = sc.nextInt();
        }
        System.out.print("검색할 값 : ");
        int key = sc.nextInt();

        int index = seqSearch(arr, n, key);
        if (index == -1)
            System.out.println("요소 발견 X");
        else
            System.out.printf("arr[%d]에서 요소 발견됨\n", index);
    }
}
