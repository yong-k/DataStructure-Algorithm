package doit_codingTest;

import java.util.Scanner;

public class C036_1541 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();

        // 덧셈 먼저 하고, 뺄셈
        String[] arr = s.split("-");
        int result = splitPlus(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            result -= splitPlus(arr[i]);
        }
        System.out.println(result);
    }

    static int splitPlus(String str) {
        String[] arr = str.split("[+]");
        int sum = 0;
        for (String s : arr)
            sum += Integer.parseInt(s);
        return sum;
    }
}
