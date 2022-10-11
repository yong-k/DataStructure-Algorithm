package baekjoon_step.Step08_basicMath2;

import java.io.*;
public class B034_2581 {
    public static void main(String[] args) throws IOException {
        int[] arr = new int[10001];
        for (int i = 2; i < arr.length; i++)
            arr[i] = i;
        for (int i = 2; i < Math.sqrt(arr.length); i++) {
            if (arr[i] == 0)
                continue;
            for (int j = i + i; j < arr.length; j += i)
                arr[j] = 0;
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());
        int sum = 0; int min = 0;
        for (int i = M; i <= N; i++) {
            if (min == 0 && arr[i] != 0)
                min = arr[i];
            sum += arr[i];
        }
        if (sum != 0) {
            System.out.println(sum);
            System.out.println(min);
        }
        else
            System.out.println(-1);
    }
}
