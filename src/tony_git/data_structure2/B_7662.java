package tony_git.data_structure2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B_7662 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());        // 테스트 데이터 개수
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < T; i++) {
            PriorityQueue<Integer> maxPq = new PriorityQueue<>(Collections.reverseOrder());
            PriorityQueue<Integer> minPq = new PriorityQueue<>();
            HashMap<Integer, Integer> map = new HashMap<>();        //
            int size = 0;
            int Q = Integer.parseInt(br.readLine());    // 적용할 연산의 개수
            StringTokenizer st;

            for (int j = 0; j < Q; j++) {
                st = new StringTokenizer(br.readLine());
                String order = st.nextToken();
                int num = Integer.parseInt(st.nextToken());

                if (order.equals("I")) {    // I: 정수 삽입
                    maxPq.add(num);
                    minPq.add(num);
                    map.put(num, map.getOrDefault(map.get(num), 0) + 1);
                    size++;
                } else {
                    if (size == 0) continue;
                    if (num == 1) {            // D 1: 최댓값 삭제
                        while (size > 0) {
                            int pollNum = maxPq.poll();
                            if (map.get(pollNum) > 0) {
                                map.put(pollNum, map.get(pollNum) - 1);
                                size--;
                                break;
                            }
                        }
                    } else {                   // D -1: 최솟값 삭제
                        while (size > 0) {
                            int pollNum = minPq.poll();
                            if (map.get(pollNum) > 0) {
                                map.put(pollNum, map.get(pollNum) - 1);
                                size--;
                                break;
                            }
                        }
                    }
                }
            }

            if (size == 0)
                sb.append("EMPTY\n");
            else
                sb.append(maxPq.poll() + " " + minPq.poll()).append('\n');
        }
        System.out.print(sb);
    }
}
