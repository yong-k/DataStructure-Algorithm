package inflearn_algorithm.ch01_String;

import java.io.*;
public class C07 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int s = 0;
        int e = str.length() - 1;
        boolean flag = true;
        while (s < e) {
            if (Character.toLowerCase(str.charAt(s)) != Character.toLowerCase(str.charAt(e))) {
                flag = false;
                break;
            }
            s++;
            e--;
        }
        if (flag)
            System.out.println("YES");
        else
            System.out.println("NO");
    }
}
