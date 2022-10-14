package baekjoon_step.Step28_twoPointer;

import java.io.*;
import java.util.*;
public class B_3273 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);
        int x = Integer.parseInt(br.readLine());
        int start = 0;
        int end = arr.length - 1;
        int count = 0;
        while (start < end) {
            if (arr[start] + arr[end] == x) {
                count++;
                start++;
                end--;
            } else if (arr[start] + arr[end] < x)
                start++;
            else
                end--;
        }
        System.out.println(count);
    }
}
