package codingTestStudy.week1;

import java.io.*;
import java.util.*;
public class B_10815 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        // 상근이가 가지고 있는 숫자 카드 추가
        HashSet<Integer> set = new HashSet<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            set.add(Integer.parseInt(st.nextToken()));
        }

        // 입력받은 카드 갖고 있는지 확인
        StringBuilder sb = new StringBuilder();
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            int card = Integer.parseInt(st.nextToken());
            if (set.contains(card))
                sb.append(1).append(' ');
            else
                sb.append(0).append(' ');
        }
        System.out.println(sb);
    }
}
