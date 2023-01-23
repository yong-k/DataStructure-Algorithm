
import java.io.*;
import java.util.*;

public class T999_practice {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);

        int find = Integer.parseInt(br.readLine());
        int count = 0;
        int start = 0;
        int end = n - 1;
        while (start < end) {
            if (arr[start] + arr[end] < find)
                start++;
            else if (arr[start] + arr[end] > find)
                end--;
            else {
                count++;
                start++;
                end--;
            }
        }
        System.out.println(count);
    }
}

