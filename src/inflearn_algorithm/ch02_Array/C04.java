package inflearn_algorithm.ch02_Array;

import java.io.*;
public class C04 {
    static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n];
        fibonacci(n);
        for (int x : arr)
            System.out.print(x + " ");
    }

    public static void fibonacci(int n) {
        arr[0] = 1;
        arr[1] = 1;
        for (int i = 2; i < arr.length; i++)
            arr[i] = arr[i - 1] + arr[i - 2];
    }
}
