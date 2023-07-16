package codingTestStudy.week1;

import java.io.*;
import java.util.*;
public class B_1764 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        HashMap<String, Integer> map = new HashMap<>();
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N + M; i++) {
            String name = br.readLine();
            if (!map.containsKey(name))
                map.put(name, 1);
            else
                map.put(name, map.get(name) + 1);
        }

        for (String name : map.keySet()) {
            if (map.get(name) > 1)
                result.add(name);
        }

        Collections.sort(result);
        sb.append(result.size()).append('\n');
        for (String name : result)
            sb.append(name).append('\n');

        System.out.println(sb);
    }
}
