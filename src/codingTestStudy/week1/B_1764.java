package codingTestStudy.week1;

import java.io.*;
import java.util.*;
public class B_1764 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 듣도 못한 사람 ∩ 보도 못한 사람
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < N + M; i++) {
            String name = br.readLine();
            map.put(name, map.getOrDefault(name, 0) + 1);
        }

        // map 돌면서, 개수가 2인 거 찾아서 names 리스트에 추가
        List<String> names = new ArrayList<>();
        for (String key : map.keySet()) {
            if (map.get(key) >= 2)
                names.add(key);
        }

        // 사전순으로 출력 → names 리스트 정렬
        Collections.sort(names);

        // 결과 출력
        StringBuilder sb = new StringBuilder();
        sb.append(names.size()).append('\n');
        for (String name : names)
            sb.append(name).append('\n');
        System.out.print(sb);
    }
}
