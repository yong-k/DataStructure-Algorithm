package baekjoon;

// 10430
import java.io.*;
import java.util.*;
public class B008_10430 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        System.out.println((a + b) % c);
        System.out.println((a % c + b % c) % c);
        System.out.println((a * b) % c);
        System.out.println((a % c * b % c) % c);
    }
}
