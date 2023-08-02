package tony_git.binary_search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_10816 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(arr);

        int M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int find = Integer.parseInt(st.nextToken());
            int left = 0;
            int right = N - 1;
            int count = 0;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (arr[mid] == find) {
                    count++;
                    // 좌우로 같은 숫자 없는지 체크해야함
                    int checkLeft = mid - 1;
                    for (int k = checkLeft; k >= 0; k--) {
                        if (arr[k] == find)
                            count++;
                        else
                            break;
                    }

                    int checkRight = mid + 1;
                    for (int k = checkRight; k < N; k++) {
                        if (arr[k] == find)
                            count++;
                        else
                            break;
                    }
                    break;
                } else if (arr[mid] < find) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            sb.append(count).append(' ');
        }
        System.out.println(sb);
    }
}
