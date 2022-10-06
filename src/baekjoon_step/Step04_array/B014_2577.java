package baekjoon_step.Step04_array;

// 2577
import java.io.*;
public class B014_2577 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int result = Integer.parseInt(br.readLine()) * Integer.parseInt(br.readLine()) * Integer.parseInt(br.readLine());
        char[] arr = (Integer.toString(result)).toCharArray();
        char[] check = new char[10];

        for (int i = 0; i < arr.length; i++)
            check[arr[i] - '0']++;

        for (int x : check)
            System.out.println(x);
    }
}
