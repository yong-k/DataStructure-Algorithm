package doit_algorithm.ch02;

import java.util.Scanner;

// 실습 2-4
public class p51 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("사람 수 : ");
        int size = sc.nextInt();
        int[] arr = new int[size];
        for (int i = 0; i < arr.length; i++) {
            System.out.printf("height[%d]: ", i);
            arr[i] = sc.nextInt();
        }
        int max = arr[0];
        for (int i = 1; i < arr.length; i++)
            if (arr[i] > max) max = arr[i];
        System.out.printf("최댓값은 %d입니다.", max);
    }
}
