import java.util.*;

public class T999_practice {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int[] sum = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            sum[i] = sum[i - 1] + sc.nextInt();
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            sb.append(sum[e] - sum[s - 1]).append('\n');
        }
        System.out.println(sb);
    }
}
