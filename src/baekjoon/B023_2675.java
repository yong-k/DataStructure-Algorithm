package baekjoon;

import java.io.*;
import java.util.*;

public class B023_2675 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int strLoop = Integer.parseInt(st.nextToken());
            String str = st.nextToken();
            for (int j = 0; j < str.length(); j++)
                for (int k = 0; k < strLoop; k++)
                    sb.append(str.charAt(j));
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
