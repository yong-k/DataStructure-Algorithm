package doit_algorithm.ch06_sorting;

import java.util.Scanner;

public class p229_quickSort {
    static void swap(int[] arr, int idx1, int idx2) {
        int tmp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = tmp;
    }

    static void quickSort(int[] arr, int left, int right) {
        int pl = left;
        int pr = right;
        int x = arr[(pl + pr) / 2];

        // 배열 나누는 과정 출력하려면
        System.out.printf("arr[%d]~arr[%d] : {", left, right);
        for (int i = left; i < right; i++)
            System.out.printf("%d, ", arr[i]);
        System.out.printf("%d}\n", arr[right]);

        do {
            while (arr[pl] < x) pl++;
            while (arr[pr] > x) pr--;
            if (pl <= pr)
                swap(arr, pl++, pr--);
        } while (pl <= pr);

        if (left < pr) quickSort(arr, left, pr);
        if (pl < right) quickSort(arr, pl, right);
    }

    // p231-Q10
    static void quickSort(int[] arr, int size) {
        quickSort(arr, 0, size - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("요소 개수: ");
        int size = sc.nextInt();
        int[] arr = new int[size];

        for (int i = 0; i < arr.length; i++) {
            System.out.print("arr[" + i + "] : ");
            arr[i] = sc.nextInt();
        }

        //quickSort(arr, 0, size-1);
        quickSort(arr, size);

        System.out.println("오름차순 정렬 완료");
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
}
