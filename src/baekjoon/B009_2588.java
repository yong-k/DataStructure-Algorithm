package baekjoon;

// 2588
import java.io.*;
public class B009_2588 {
    public static void main(String[] args) throws IOException {
        /*
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        String b = sc.next();
        for (int i = b.length() - 1; i >= 0; i--)
            System.out.println(a * Integer.parseInt(b.substring(i, i+1)));
        System.out.println(a * Integer.parseInt(b));
        */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        String b = br.readLine();
        System.out.println(a * (b.charAt(2) - '0'));
        System.out.println(a * (b.charAt(1) - '0'));
        System.out.println(a * (b.charAt(0) - '0'));
        System.out.println(a * Integer.parseInt(b));
    }
}
