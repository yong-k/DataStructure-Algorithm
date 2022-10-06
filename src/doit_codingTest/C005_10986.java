package doit_codingTest;

import java.util.Scanner;

// 백준 10986
public class C005_10986 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[sc.nextInt()];
        int mod = sc.nextInt();
        int[] modArr = new int[mod];
        int count = 0;

        arr[0] = sc.nextInt();
        for (int i = 1; i < arr.length; i++)
            arr[i] = (arr[i - 1] + sc.nextInt());

        for (int i = 0; i < arr.length; i++) {
            arr[i] %= mod;
            if (arr[i] == 0) count++;
            modArr[arr[i]]++;
        }

        for (int i = 0; i < modArr.length; i++) {
            if (modArr[i] > 1)
                count += modArr[i] * (modArr[i] - 1) / 2;
        }

        System.out.println(count);
    }
}
