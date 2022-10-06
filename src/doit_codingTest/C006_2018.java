package doit_codingTest;

import java.util.Scanner;

// 백준 2018
public class C006_2018 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int start_idx = 1, end_idx = 1;
        int count = 1, sum = 1;

        while (end_idx != N) {
            if (sum == N) {
                count++;
                end_idx++;
                sum += end_idx;
            } else if (sum < N) {
                end_idx++;
                sum += end_idx;
            } else {
                sum -= start_idx;
                start_idx++;
            }
        }

        System.out.println(count);
    }
}
