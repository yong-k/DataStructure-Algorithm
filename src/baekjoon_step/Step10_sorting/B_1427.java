package baekjoon_step.Step10_sorting;

import java.io.*;
import java.util.*;

public class B_1427 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = br.readLine().toCharArray();

        Arrays.sort(arr);

        StringBuilder sb = new StringBuilder();
        for (char x : arr)
            sb.append(x);

        System.out.println(sb.reverse().toString());
    }
}
