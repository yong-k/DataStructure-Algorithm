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

        List<String> list = new ArrayList<>(map.keySet());
        Collections.sort(list);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            String name = list.get(i);
            double rate = (double)map.get(name) / total * 100;
            sb.append(name + ' ' + String.format("%.4f", rate)).append('\n');
        }
        System.out.println(sb);
    }
}
