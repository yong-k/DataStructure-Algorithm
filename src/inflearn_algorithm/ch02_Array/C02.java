package inflearn_algorithm.ch02_Array;

import java.io.*;
import java.util.*;
public class C02 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[Integer.parseInt(br.readLine())];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < arr.length; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        int count = 1;
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                count++;
                max = arr[i];
            }
        }
        System.out.println(count);
    }
}
