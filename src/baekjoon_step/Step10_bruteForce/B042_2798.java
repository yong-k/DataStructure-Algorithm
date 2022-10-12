package baekjoon_step.Step10_bruteForce;

import java.io.*;
import java.util.*;
public class B042_2798 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < arr.length; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);

        int sum = 0;
        int max = 0;
        for (int i = arr.length - 1; i >= 2; i--) {
            for (int j = i - 1; j >= 1; j--) {
                sum = arr[i] + arr[j];
                for (int k = j - 1; k >= 0; k--) {
                    if (sum + arr[k] <= M && sum + arr[k] > max) {
                        max = sum + arr[k];
                    }
                }
            }
        }
        System.out.println(max);
    }
}
