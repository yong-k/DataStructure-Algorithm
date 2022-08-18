package doit_algorithm.ch03;

import java.util.Scanner;

public class p117Q3 {
    static int searchIdx(int[] arr, int key) {
        arr[arr.length-1] = key;
        int count = 0;
        int[] idx;
        for (int x : arr)
            if (x == key) count++;
        if (count == 1) return 0;
        else {
            idx = new int[count-1];
            for (int i = 0; i < arr.length - 1; i++) {
                int index = 0;
                if (arr[i] == key) {
                    idx[index] = i;
                    System.out.printf("%d ", idx[index++]);
                }
            }
            System.out.println();
        }
        return count-1;
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


        int keyCount = searchIdx(arr, key);
        if (keyCount == 0)
            System.out.println("요소 발견 X");
        else
            System.out.printf("%d는 %d개\n", key, keyCount);
    }
}
