package inflearn_algorithm.ch02_Array;

import java.io.*;
import java.util.*;
public class C06 {
    static boolean[] prime = new boolean[100001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringBuilder result = new StringBuilder();
        isPrime();
        for (int i = 0; i < n; i++) {
            char[] arr = (st.nextToken()).toCharArray();
            sb.setLength(0);
            for (int j = arr.length - 1; j >= 0; j--)
                sb.append(arr[j]);
            if (!prime[Integer.parseInt(sb.toString())])
                result.append(Integer.parseInt(sb.toString()) + " ");
        }
        System.out.println(result);
    }

    static void isPrime() {
        prime[0] = prime[1] = true;
        for (int i = 2; i <= Math.sqrt(prime.length); i++) {
            if (prime[i])
                continue;
            for (int j = i * i; j < prime.length; j += i)
                prime[j] = true;
        }
    }
}
