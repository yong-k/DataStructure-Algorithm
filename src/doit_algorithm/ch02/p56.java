package doit_algorithm.ch02;

import java.util.Random;
import java.util.Scanner;

// Q1
public class p56 {
    static int maxOf(int[] a) {
        int max = a[0];
        for (int i = 1; i < a.length; i++)
            if (a[i] > max) max = a[i];
        return max;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rm = new Random();
        int size = rm.nextInt(10)+1;
        System.out.printf("사람 수 : %d\n", size);
        int[] arr = new int[size];
        for (int i = 0; i <arr.length; i++) {
            arr[i] = rm.nextInt(90) + 100;
            System.out.printf("arr[%d] : %d\n", i, arr[i]);
        }
        System.out.printf("최댓값은 %d입니다.\n", maxOf(arr));



    }
}
