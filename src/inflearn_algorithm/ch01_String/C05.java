package inflearn_algorithm.ch01_String;

import java.io.*;
// two pointer 로 둘 다 알파벳이면 change
public class C05 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] arr = (br.readLine()).toCharArray();
        int s = 0;
        int e = arr.length - 1;
        while (s < e) {
            // 둘 다 알파벳이면 change
            if (((arr[s] >= 65 && arr[s] <= 90) || (arr[s] >= 97 && arr[s] <= 122))
                && ((arr[e] >= 65 && arr[e] <= 90) || (arr[e] >= 97 && arr[e] <= 122))) {
                char temp = arr[s];
                arr[s] = arr[e];
                arr[e] = temp;
                s++;
                e--;
            } else if ((arr[s] >= 65 && arr[s] <= 90) || (arr[s] >= 97 && arr[s] <= 122))
                e--;
            else if ((arr[e] >= 65 && arr[e] <= 90) || (arr[e] >= 97 && arr[e] <= 122))
                s++;
            else {
                s++;
                e--;
            }
        }
        for (char x : arr)
            System.out.print(x);
    }
}
