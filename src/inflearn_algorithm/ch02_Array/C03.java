package inflearn_algorithm.ch02_Array;

import java.io.*;
import java.util.*;
public class C03 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        int[] b = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            a[i] = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            b[i] = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            if (a[i] == b[i])
                System.out.println("D");
            else if ((a[i] == 1 && b[i] == 3) || (a[i] == 2 && b[i] == 1) || a[i] == 3 && b[i] == 2)
                System.out.println("A");
            else
                System.out.println("B");
        }
    }
}
