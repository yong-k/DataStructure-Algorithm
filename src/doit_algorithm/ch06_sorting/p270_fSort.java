package doit_algorithm.ch06_sorting;

import java.util.Scanner;

// 실습 6-17
public class p270_fSort {
    // 도수 정렬 (0 이상 max 이하의 값을 입력)
    static void fSort(int[] arr, int max) {
        int[] f = new int[max + 1];     // 누적 도수
        int[] b = new int[arr.length];  // 작업용 목적 배열

        for (int i = 0; i < arr.length; i++)        f[arr[i]]++;                // 1단계
        for (int i = 1; i <= max; i++)              f[i] += f[i - 1];           // 2단계
        for (int i = arr.length - 1; i >= 0; i--)   b[--f[arr[i]]] = arr[i];    // 3단계
        for (int i = 0; i < arr.length; i++)        arr[i] = b[i];              // 4단계
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("요소 개수: ");
        int[] arr = new int[sc.nextInt()];

        for (int i = 0; i < arr.length; i++) {
            do {
                System.out.print("arr[" + i + "] : ");
                arr[i] = sc.nextInt();
            } while (arr[i] < 0);
        }

        int max = arr[0];
        for (int i = 1; i < arr.length; i++)
            if (arr[i] > max)   max = arr[i];

        fSort(arr, max);

        System.out.println("오름차순 정렬 완료");
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
}
