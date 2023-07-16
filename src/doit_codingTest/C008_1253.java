package doit_codingTest;

import java.util.Scanner;
import java.util.Arrays;

// 백준 1253
/*
10
1 2 3 4 5 6 7 8 9 10
*/
public class C008_1253 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[sc.nextInt()];
        int count = 0;

        for (int i = 0; i < arr.length; i++)
            arr[i] = sc.nextInt();

        Arrays.sort(arr);

        for (int k = 0; k < arr.length; k++) {
            int i = 0, j = arr.length - 1;
            int find = arr[k];
            while (i < j) {
                if (arr[i] + arr[j] == find) {
                    if (i != k && j != k) {
                        count++;
                        break;
                    } else if (i == k)
                        i++;
                    else
                        j--;
                } else if (arr[i] + arr[j] < find)
                    i++;
                else
                    j--;
            }
        }
        System.out.println(count);
    }
}
