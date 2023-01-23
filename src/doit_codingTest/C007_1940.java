package doit_codingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Arrays;
import java.util.StringTokenizer;

// 백준 1940
public class C007_1940 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int count = 0;
        long[] arr = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < arr.length; i++)
            arr[i] = Long.parseLong(st.nextToken());

        Arrays.sort(arr);

        for (int i = 0; i < arr.length; i++) {
            long find = arr[i];
            int start = 0;
            int end = N - 1;
            while (start < end) {
                if (arr[start] + arr[end] == find) {
                    if (start != i && end != i) {
                        count++;
                        break;
                    } else if (start == i)
                        start++;
                    else
                        end--;
                } else if (arr[start] + arr[end] < find)
                    start++;
                else
                    end--;
            }
        }
        System.out.println(count);
    }
}
