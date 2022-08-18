package doit_algorithm.ch03;

import java.util.Scanner;

public class p115Q2 {
    static int seqSearchSen(int[] arr, int key) {
        int i = 0;
        arr[arr.length-1] = key;
        System.out.print("    |");
        for (int j = 0; j < arr.length-1; j++)
            System.out.printf("%2d", j);
        System.out.println();
        System.out.println("----+---------------");
        for (i = 0; i < arr.length; i++) {
            System.out.print("    |");
            for (int j = 1; j < i+2; j++)
                System.out.print("  ");
            System.out.println("*");
            System.out.printf("%3d |", i);
            for (int j = 0; j < arr.length-1; j++)
                System.out.printf("%2d", arr[j]);
            System.out.println();

            if (arr[i] == key) break;
        }
        return i == arr.length ? -1 : i;
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

        int index = seqSearchSen(arr, key);
        if (index == -1)
            System.out.println("요소 발견 X");
        else
            System.out.printf("arr[%d]에서 %d 발견됨\n", index, key);
    }

}
