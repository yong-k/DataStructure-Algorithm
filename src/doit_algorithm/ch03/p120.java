package doit_algorithm.ch03;

import java.util.Arrays;
import java.util.Scanner;

// 실습 3-5
public class p120 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("요솟수: ");
        int[] arr = new int[sc.nextInt()];
        System.out.println("오름차순으로 입력하세요.");
        System.out.print("arr[0]: ");
        arr[0] = sc.nextInt();
        for (int i = 1; i < arr.length; i++) {
            do {
                System.out.printf("arr[%d]: ", i);
                arr[i] = sc.nextInt();
            } while (arr[i] < arr[i-1]);
        }

        System.out.print("검색할 값 : ");
        int key = sc.nextInt();

        int idx = Arrays.binarySearch(arr, key);

        if (idx < 0) {
            System.out.println("요소 X");
            System.out.printf("삽입 포인트: " + idx);
        }
        else
            System.out.println(idx + "번째에 있음");
    }
}
