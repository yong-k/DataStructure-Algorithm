package doit_codingTest;

import java.util.Scanner;
import java.util.Arrays;

// 백준 1940
public class C007_1940 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int sum = sc.nextInt();
        int[] arr = new int[size];
        for (int i = 0; i < arr.length; i++)
            arr[i] = sc.nextInt();

        Arrays.sort(arr);

        int i = 0;
        int j = arr.length - 1;
        int count = 0;
        while (i < j) {
            if (arr[i] + arr[j] == sum) {
                count++;
                i++;
                j--;
            } else if (arr[i] + arr[j] < sum)
                i++;
            else
                j--;
        }
        System.out.println(count);
    }
}
