package doit_algorithm.ch06_sorting;

import java.util.Arrays;
import java.util.Scanner;

public class p245_mergeSort {
    static int[] buff;  // 작업용 배열

    // a[left] ~ a[right]를 재귀적으로 병합 정렬 => 실제 정렬 작업 수행
    static void __mergeSort(int[] a, int left, int right) {
        if (left < right) {
             int i;
             int center = (left + right) / 2;
             int p = 0;
             int j = 0;
             int k = left;

             __mergeSort(a, left, center);          // 배열의 앞부분을 병합 정렬
             __mergeSort(a, center + 1, right); // 배열의 뒷부분을 병합 정렬

            for (i = left; i <= center; i++)
                buff[p++] = a[i];

            while (i <= right && j < p)
                a[k++] = (buff[j] <= a[i]) ? buff[j++] : a[i++];

            while (j < p)
                a[k++] = buff[j++];
        }
    }

    static void mergeSort(int[] a) {
        buff = new int[a.length];                     // 작업용 배열 생성
        __mergeSort(a, 0, a.length - 1);    // 배열 전체를 병합 정렬
        buff = null;                                  // 작업용 배열 해제
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("요소 개수: ");
        int[] a = new int[sc.nextInt()];

        for (int i = 0; i < a.length; i++)
            a[i] = sc.nextInt();

        mergeSort(a);

        System.out.println("오름차순 정렬 완료");
        for (int x : a)
            System.out.print(x + " ");
        System.out.println();
    }
}
