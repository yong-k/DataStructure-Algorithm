package inflearn_algorithm.ch02_Array;

import java.io.*;
import java.util.*;
public class C01 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[Integer.parseInt(br.readLine()) + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i < arr.length; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        for (int i = 1; i < arr.length; i++)
            if (arr[i] > arr[i - 1])
                System.out.print(arr[i] + " ");
    }
}
