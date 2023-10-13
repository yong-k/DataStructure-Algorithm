package tony_git.data_structure2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class B_1620_map1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        HashMap<String, String> map = new HashMap<>();

        for (int i= 1; i <= N; i++) {
            String name = br.readLine();
            String num = String.valueOf(i);
            map.put(name, num);
            map.put(num, name);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++)
            sb.append(map.get(br.readLine())).append('\n');
        System.out.print(sb);
    }
}