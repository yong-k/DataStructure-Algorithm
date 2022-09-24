package doit_algorithm.ch06_sorting;

import java.util.Scanner;

public class p264_heapSort {
    static void swap(int[] arr, int idx1, int idx2) {
        int tmp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = tmp;
    }

    // a[left] ~ a[right]를 힙으로 만듦
    static void downHeap(int[] arr, int left, int right) {
        int temp = arr[left];   // 루트값을 대입
        int child;              // 왼/오 자식 중 큰 값 가진 거 대입할 변수
        int parent;             // 부모

        for (parent = left; parent < (right + 1) / 2; parent = child) {
            int cl = parent * 2 + 1;    // 왼쪽 자식
            int cr = cl + 1;            // 오른쪽 자식
            child = (cr <= right && arr[cr] > arr[cl]) ? cr : cl;   // 큰 값 가진 노드를 자식에 대입
            if (temp > arr[child])
                break;
            arr[parent] = arr[child];
        }
        arr[parent] = temp;
    }

    // 힙 정렬
    static void heapSort(int[] arr) {
        // a[i] ~ a[arr.length-1]를 힙으로 만들기
        for (int i = (arr.length - 1) / 2; i >= 0; i--)
            downHeap(arr, i, arr.length - 1);

        for (int i = arr.length - 1; i > 0; i--) {
            swap(arr, 0, i);    // 루트와 마지막요소 교환
            downHeap(arr, 0, i - 1);    // a[0] ~ a[i-1]를 힙으로 만들기
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("요소 개수: ");
        int[] arr = new int[sc.nextInt()];
        for (int i = 0; i < arr.length; i++) {
            System.out.print("arr[" + i + "] : ");
            arr[i] = sc.nextInt();
        }

        heapSort(arr);

        System.out.println("오름차순 정렬 완료");
        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }
}
