package tony_git.data_structure2;

import java.util.*;
public class B_4358 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String, Integer> map = new HashMap<>();

        int total = 0;
        while (sc.hasNextLine()) {
            String name = sc.nextLine();
            map.put(name, map.getOrDefault(name, 0) + 1);
            total++;
        }

        List<String> names = new ArrayList<>(map.keySet());
        Collections.sort(names);

        StringBuilder sb = new StringBuilder();
        for (String name : names) {
            double rate = (double)map.get(name) / total * 100;
            sb.append(name).append(' ').append(String.format("%.4f", rate)).append('\n');
        }
        System.out.print(sb);
    }
}
