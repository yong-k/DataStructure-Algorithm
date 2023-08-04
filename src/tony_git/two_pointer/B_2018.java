package tony_git.two_pointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B_2018 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int answer = 1;
        int start = 1;
        int end = 1;
        int sum = 1;
        while (end < N) {
            if (sum == N) {
                answer++;
                end++;
                sum += end;
            } else if (sum < N) {
                end++;
                sum += end;
            } else {
                sum -= start;
                start++;
            }
        }
        System.out.println(answer);
    }
}
