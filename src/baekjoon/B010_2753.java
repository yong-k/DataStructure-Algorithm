package baekjoon;

// 2753
import java.io.*;
public class B010_2753 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int y = Integer.parseInt(br.readLine());
        if (y % 4 == 0 && y % 100 != 0 || y % 400 == 0)
            System.out.println("1");
        else
            System.out.println("0");
    }
}
