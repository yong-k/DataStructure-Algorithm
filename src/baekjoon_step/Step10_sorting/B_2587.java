package baekjoon_step.Step10_sorting;

import java.io.*;
import java.util.*;

public class B_2587 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] arr = new int[5];
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
        }
        Arrays.sort(arr);

        System.out.println(sum/5);
        System.out.println(arr[2]);
    }
}
