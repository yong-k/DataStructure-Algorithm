package baekjoon_step.Step06_string;

import java.io.*;
import java.util.StringTokenizer;

public class B026_2908 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //StringBuilder sb1 = new StringBuilder();
        //StringBuilder sb2 = new StringBuilder();
        //int a = Integer.parseInt((sb1.append(st.nextToken()).reverse()).toString());
        //int b = Integer.parseInt((sb2.append(st.nextToken()).reverse()).toString());

        int a = Integer.parseInt(new StringBuilder(st.nextToken()).reverse().toString());
        int b = Integer.parseInt(new StringBuilder(st.nextToken()).reverse().toString());
        if (a > b)
            System.out.println(a);
        else
            System.out.println(b);
    }
}
