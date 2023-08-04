package tony_git.two_pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_3273 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(br.readLine());

        Arrays.sort(arr);

        int s = 0;
        int e = arr.length - 1;
        int answer = 0;
        while (s < e) {
            int sum = arr[s] + arr[e];
            if (sum == x) {
                answer++;
                s++;
                e--;
            } else if (sum < x)
                s++;
            else
                e--;
        }
        System.out.println(answer);
    }
}
