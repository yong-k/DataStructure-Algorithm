package doit_algorithm.ch06_sorting;

import java.util.Scanner;

public class p216Q7 {
    static void insertionSort(int[] a) {
        for (int i = 2; i < a.length; i++) {
            int j;
            a[0] = a[i];
            for (j = i; a[j - 1] > a[0]; j--)
                a[j] = a[j - 1];

            if (j > 0)
                a[j] = a[0];

            for (int k = 0; k < a.length; k++)
                System.out.print(a[k] + " ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("요소 개수: ");
        int[] a = new int[sc.nextInt() + 1];
        System.out.println(a.length);
        for (int i = 1; i < a.length; i++) {
            System.out.printf("a[%d] : ", i);
            a[i] = sc.nextInt();
        }

        insertionSort(a);

        System.out.println();
        System.out.println("오름차순 정렬 완료");
        for (int i = 1; i < a.length; i++)
            System.out.print(a[i] + " ");
        System.out.println();
    }
}
