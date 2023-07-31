package tony_git.string;

import java.io.*;

public class B_11365 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder decode = new StringBuilder();
        StringBuilder pw = new StringBuilder(br.readLine());
        String s = "";
        while (!s.equals("END")) {
            decode.append(pw.reverse()).append('\n');
            s = br.readLine();
            pw = new StringBuilder(s);
        }
        System.out.println(decode);
    }
}
