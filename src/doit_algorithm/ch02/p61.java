package doit_algorithm.ch02;

import java.util.Scanner;

public class p61 {
    static void swap(int[] a, int idx1, int idx2) {
        int temp = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = temp;
    }

    static void reverse(int[] a) {
        for (int i = 0; i < a.length/2; i++) {
            for (int x : a)
                System.out.print(x + " ");
            System.out.printf("\na[%d]과(와) a[%d]를 교환합니다.\n", i, a.length-1-i);
            swap(a, i, a.length-1-i);
        }
    }

    // Q3
    static int sumOf(int[] a) {
        int sum = 0;
        for (int x : a)
            sum += x;
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("size: ");
        int[] arr = new int[sc.nextInt()];
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("arr[%d]: ", i);
            arr[i] = sc.nextInt();
        }
        reverse(arr);
        for (int x : arr)
            System.out.print(x + " ");
        System.out.println("\n역순 정렬을 마쳤습니다.");

        System.out.println("모든 요소의 합계 : " + sumOf(arr));
    }
}
