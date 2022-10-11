package baekjoon_step.Step08_basicMath2;

import java.io.*;
import java.util.*;
public class B035_1929 {
    static boolean[] prime;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        prime = new boolean[N + 1];
        cal_prime();

        for (int i = M; i <= N; i++)
            if (!prime[i])
                System.out.println(i);
    }

    private static void cal_prime() {
        prime[0] = prime[1] = true;
        for (int i = 2; i <= Math.sqrt(prime.length); i++) {
            if (prime[i])
                continue;
            for (int j = i + i; j < prime.length; j += i)
                prime[j] = true;
        }
    }

    /*
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] arr = new int[1000001];
        for (int i = 2; i < arr.length; i++)
            arr[i] = i;
        for (int i = 2; i < Math.sqrt(arr.length); i++) {
            if (arr[i] == 0)
                continue;
            for (int j = i + i; j < arr.length; j += i)
                arr[j] = 0;
        }

        for (int i = M; i <= N; i++)
            if (arr[i] != 0)
                System.out.println(arr[i]);
    }
    */
}
