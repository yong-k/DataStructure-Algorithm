package codingTestStudy.week1;

import java.io.*;
import java.util.*;
public class B_1427_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = br.readLine().toCharArray();
        Arrays.sort(arr);

        // 방법 1)
        /*
        StringBuilder sb = new StringBuilder();
        for (char c : arr)
            sb.insert(0, c);
        System.out.println(Integer.parseInt(sb.toString()));
         */

        // 방법 2)
        StringBuilder sb = new StringBuilder();
        for (char c : arr)
            sb.append(c);
        System.out.println(Integer.parseInt(sb.reverse().toString()));
    }
}
