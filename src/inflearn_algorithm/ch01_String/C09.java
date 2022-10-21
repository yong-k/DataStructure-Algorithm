package inflearn_algorithm.ch01_String;

import java.io.*;
public class C09 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++)
            if (str.charAt(i) - '0' >= 0 && str.charAt(i) - '0' <= 9)
                sb.append(str.charAt(i));
        System.out.println(Integer.parseInt(sb.toString()));
    }
}
