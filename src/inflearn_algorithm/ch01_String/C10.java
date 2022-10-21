package inflearn_algorithm.ch01_String;

import java.io.*;
import java.util.*;
public class C10 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        String s = st.nextToken();
        char t = (st.nextToken()).charAt(0);
        int[] arr = new int[s.length()];
        int now = -1;
        int prev = -1;
        int num = 1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != t)
                arr[i] = num++;
            else {
                arr[i] = 0;
                prev = now;
                now = i;
                if (prev == -1) {
                    for (int j = 0; j < now; j++)
                        arr[j] = now - arr[j] + 1;
                } else {
                    int distance = now - prev - 1;
                    for (int j = prev + 1; j < now; j++) {
                        if (arr[j] > distance)
                            arr[j] = distance;
                        distance--;
                    }
                }
                num = 1;
            }
        }
        for (int x : arr)
            System.out.print(x + " ");
    }
}
