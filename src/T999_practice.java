import java.io.*;
import java.util.*;
public class T999_practice {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());   // 이미 가지고 있는 랜선 개수
        int N = Integer.parseInt(st.nextToken());   // 필요한 랜선 개수
        int[] arr = new int[K];
        long max = 0;

        for (int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, arr[i]);
        }

        long start = 1;
        long end = max;
        long answer = 0;
        while (start <= end) {
            long count = 0;
            long mid = (start + end) / 2;
            for (int i = 0; i < arr.length; i++)
                count += arr[i] / mid;

            if (count >= N) {
                // 더 늘려도 되는지 확인해봐야지
                start = mid + 1;
                answer = Math.max(answer, mid);
            } else {
                end = mid - 1;
            }
        }
        System.out.println(answer);
    }
}

