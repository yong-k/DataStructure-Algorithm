package doit_algorithm.ch06_sorting;

import java.util.Scanner;

// 실습 6-5
public class p214 {
    static void insertionSort(int[] a) {
        for (int i = 1; i < a.length; i++) {
            int j;
            int temp = a[i];
            for (j = i; j > 0 && a[j - 1] > temp; j--)
                a[j] = a[j - 1];
            a[j] = temp;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("요소 개수: ");
        int[] a = new int[sc.nextInt()];

        for (int i = 0; i < a.length; i++) {
            System.out.printf("a[%d] : ", i);
            a[i] = sc.nextInt();
        }

        insertionSort(a);

        System.out.println();
        System.out.println("오름차순 정렬 완료");
        for (int x : a)
            System.out.printf("%d ", x);
        System.out.println();
    }
}
