package doit_codingTest;

// 백준 11720

import java.util.Scanner;
import java.io.*;
public class C001_11720 {
    public static void main(String[] args) throws IOException {

        // 방법1: substring() 사용
        // 시간: 228ms
        /*
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        String number = sc.next();
        int sum = 0;

        for (int i = 0; i < size; i++)
            sum += Integer.parseInt(number.substring(i, i+1));

        System.out.println(sum);
        */

        // 방법2: toCharArray(), 아스키코드 사용
        // 시간: 208ms
        /*
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        char[] arr = new char[size];
        String number = sc.next();
        arr = number.toCharArray();

        int sum = 0;
        for (int i = 0; i < arr.length; i++)
            //sum += arr[i] - '0';
            sum += arr[i] - 48;

        System.out.println(sum);
        */

        // 방법3: charAt(), 아스키코드 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        br.readLine();  // 숫자 개수 필요없으니 그냥 읽기만 함
        String str = br.readLine();
        int sum = 0;
        for (int i = 0; i < str.length(); i++)
            sum += str.charAt(i) - '0';
        System.out.println(sum);
    }
}
