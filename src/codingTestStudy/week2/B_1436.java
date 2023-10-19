package codingTestStudy.week2;

import java.io.*;
public class B_1436 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int count = 0;
        int movieNum = 665;
        while (count != N) {
            movieNum++;
            if (String.valueOf(movieNum).contains("666"))
                count++;
        }
        System.out.println(movieNum);
    }
}
