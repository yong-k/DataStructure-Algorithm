package doit_algorithm.ch06_sorting;

import java.util.Scanner;

public class p222_shellSort {

    static int swapCount = 0;      // p223-Q9
    static void shellSort(int[] arr) {
        int h;
        for (h = 1; h < arr.length; h = h * 3 + 1)
            ;

        for ( ; h > 0; h /= 3)
            for (int i = h; i < arr.length; i++) {
                int j;
                int temp = arr[i];
                for (j = i - h; j >= 0 && arr[j] > temp; j -= h) {
                    arr[j + h] = arr[j];
                    swapCount++;
                }
                arr[j + h] = temp;
                swapCount++;
            }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("요소 개수: ");
        int[] arr = new int[sc.nextInt()];

        for (int i = 0; i < arr.length; i++)
            arr[i] = sc.nextInt();

        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
        System.out.println();

        shellSort(arr);

        System.out.println("정렬 후");
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
        System.out.println();

        System.out.printf("총 %d번 이동했음\n", swapCount);
    }
}
