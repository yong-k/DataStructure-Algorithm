package doit_algorithm.ch06_sorting;

import java.util.Scanner;

// 버블정렬
public class p202p204Q1p205p207p208Q5 {
    // a[idx1]와 a[idx2]의 값을 바꿈
    static void swap(int[] a, int idx1, int idx2) {
        int temp = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = temp;
    }

    // 버블정렬 (버전 1) : p202 실습 6-1
    /*
    static void bubbleSort(int[] a) {
        // 방법1. 배열의 뒷쪽부터 비교/교환 수행 → 각 패스에서 가장 작은 값의 요소가 앞으로 옮겨짐
        for (int i = 0; i < a.length-1; i++)
            for (int j = a.length-1; j > i; j--)
                if (a[j-1] > a[j])
                    swap(a, j-1, j);

        // p204-Q1
        // 방법2. 배열의 앞쪽부터 비교/교환 수행 → 각 패스에서 가장 큰 값의 요소가 끝으로 옮겨짐
        for (int i = 0; i < a.length-1; i++)
            for (int j = i; j < a.length-1; j++)
                if (a[j] > a[j+1])
                    swap(a, j, j+1);
    }
    */

    // 버블정렬 (버전 2) : p205 실습 6-2
    /*
    static void bubbleSort(int[] a) {
        int exchg;
        for (int i = 0; i < a.length-1; i++) {
            exchg = 0;
            for (int j = a.length-1; j > i; j--)
                if (a[j-1] > a[j]) {
                    swap(a, j-1, j);
                    exchg++;
                }
            if (exchg == 0) break;     // 교환횟수가 0이면 종료
        }
    }
    */

    // 버블정렬 (버전 3) : p207 실습 6-3
    /*
    static void bubbleSort(int[] a) {
       int k = 0;   // a[k]보다 앞쪽은 정렬을 마친 상태
       while (k < a.length - 1) {
           int last = a.length - 1;     // 마지막으로 요소를 교환한 위치
           for (int j = a.length - 1; j > k; j--)
               if (a[j-1] > a[j]) {
                   swap(a, j-1, j);
                   last = j;
               }
           k = last;
       }
    }
    */

    // p208-Q5 : 양방향 버블 정렬, 칵테일 정렬, 셰이커 정렬
    static void bubbleSort(int[] a) {
        int front = 0;
        int rear = a.length - 1;
        int last = a.length - 1;    // swap() 이 끝난 마지막 인덱스 위치
        int count = 1;              // 반복 횟수 세기 위한 변수
        boolean isSwap;             // swap 발생 여부 체크

        // 최대 n-1번 반복하니까
        while (count < a.length) {
            isSwap = false;
            // 홀수: 가장 작은 요소를 맨 앞으로 옮김(뒤부터 스캔)
            if (count % 2 == 1) {
                for (int j = rear; j > front; j--)
                    if (a[j-1] > a[j]) {
                        swap(a, j-1, j);
                        isSwap = true;
                        last = j;
                    }
                front = last;
            }
            // 짝수: 가장 큰 요소를 맨 뒤로 옮김(앞부터 스캔)
            else {
                for (int j = front; j < rear; j++)
                    if (a[j] > a[j+1]) {
                        swap(a, j, j+1);
                        isSwap = true;
                        last = j;
                    }
                rear = last;
            }

            System.out.println(count++ + "회 반복");
            if (front == a.length - 1 || front == rear || isSwap == true) {
                System.out.println("정렬 완료 - stop");
                break;
            }
            for (int x : a)
                System.out.print(x + " ");
            System.out.println();
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

        bubbleSort(a);

        System.out.println();
        System.out.println("오름차순 정렬 완료");
        for (int x : a)
            System.out.printf("%d ", x);
        System.out.println();
    }
}
