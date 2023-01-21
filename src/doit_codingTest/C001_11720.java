package doit_codingTest;

// 백준 11720

import java.util.Scanner;
import java.io.*;
public class C001_11720 {
    static void solution(int n, String s) {
        int result = 0;
        for (int i = 0; i < s.length(); i++)
            result += s.charAt(i) - '0';
        System.out.println("result = " + result);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = sc.next();
        solution(n, s);
    }
}
