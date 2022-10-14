
import java.io.*;
import java.util.*;
public class T999_practice<T> {
    public static void main(String[] args) throws IOException {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);

        int s = 0;
        int e = N - 1;
        int count = 0;
        while (s < e) {
            if (arr[s] + arr[e] == M) {
                count++;
                s++;
                e--;
            } else if (arr[s] + arr[e] < M)
                s++;
            else
                e--;
        }
        System.out.println(count);
    }


}

