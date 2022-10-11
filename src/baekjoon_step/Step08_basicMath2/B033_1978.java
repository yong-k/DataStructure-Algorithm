package baekjoon_step.Step08_basicMath2;

import java.io.*;
import java.util.*;
public class B033_1978 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[1001];
        for (int i = 2; i < arr.length; i++)
            arr[i] = i;
        for (int i = 2; i <= Math.sqrt(arr.length); i++) {
            if (arr[i] == 0)
                continue;
            for (int j = i + i; j < arr.length; j += i)
                arr[j] = 0;
        }

        int count = 0;
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            if (arr[Integer.parseInt(st.nextToken())] != 0)
                count++;
        System.out.println(count);

    }
}
