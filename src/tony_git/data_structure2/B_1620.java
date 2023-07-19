package tony_git.data_structure2;

import java.util.*;
public class B_1620 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        HashMap<String, Integer> map1 = new HashMap<>();
        HashMap<Integer, String> map2 = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= N; i++) {
            String name = sc.next();
            map1.put(name, i);
            map2.put(i, name);
        }

        for (int i = 0; i < M; i++) {
            String key = sc.next();
            if (key.charAt(0) - 'A' >= 0)
                sb.append(map1.get(key)).append('\n');
            else
                sb.append(map2.get(Integer.parseInt(key))).append('\n');
        }
        System.out.println(sb);
    }
}
