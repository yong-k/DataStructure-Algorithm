package doit_algorithm.ch06_sorting;

import java.util.Scanner;

public class p242_mergeArray {
    static void merge(int[] a, int[] b, int[] c) {
        int pa = 0, pb = 0, pc = 0;

        while (pa < a.length && pb < b.length)
            c[pc++] = (a[pa] <= b[pb]) ? a[pa++] : b[pb++];

        while (pa < a.length)
            c[pc++] = a[pa++];

        while (pb < b.length)
            c[pc++] = b[pb++];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] a = {2, 4, 6, 8, 11, 13};
        int[] b = {1, 2, 3, 4, 9, 16, 21};
        int[] c = new int[13];

        System.out.println("두 배열 병합");
        merge(a, b, c);
        System.out.println("배열 a");
        for (int x : a)
            System.out.print(x + " ");
        System.out.println("\n배열 b");
        for (int x : b)
            System.out.print(x + " ");
        System.out.println("\n병합된 배열 c");
        for (int x : c)
            System.out.print(x + " ");
        System.out.println();
    }
}
