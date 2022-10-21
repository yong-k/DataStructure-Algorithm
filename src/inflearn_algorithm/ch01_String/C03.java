package inflearn_algorithm.ch01_String;

import java.io.*;
public class C03 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = (br.readLine()).split(" ");
        int maxLength = 0;
        for (int i = 1; i < arr.length; i++)
            if (arr[i].length() > arr[maxLength].length())
                maxLength = i;
        System.out.println(arr[maxLength]);
    }
}
