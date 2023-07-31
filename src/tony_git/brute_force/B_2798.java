package tony_git.brute_force;

import java.io.*;
import java.util.*;
public class B_2798 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());   // 카드의 개수
        int M = Integer.parseInt(st.nextToken());   // M이하의 최댓값 구하기
        int[] cards = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < cards.length; i++)
            cards[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(cards);

        // 3장 고르면서, 최댓값 구함
        int answer = Integer.MIN_VALUE;
        for (int i = 0; i < cards.length - 2; i++) {
            for (int j = i + 1; j < cards.length - 1; j++) {
                for (int k = j + 1; k < cards.length; k++) {
                    int sum = cards[i] + cards[j] + cards[k];
                    if (sum <= M) {
                        answer = Math.max(answer, sum);
                    }
                }
            }
        }
        System.out.println(answer);
    }
}
