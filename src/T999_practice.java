
import java.util.*;

public class T999_practice {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        List<Integer> listXY;
        int N = sc.nextInt();
        for (int i = 0; i < N; i++) {
            int n = sc.nextInt();
            list.add(n);
            map.put(n, -1);
        }

        listXY = new ArrayList<>(map.keySet());
        Collections.sort(listXY);
        for (int i = 0; i < listXY.size(); i++)
            map.put(listXY.get(i), i);

        for (int i : list)
            System.out.print(map.get(i) + " ");
    }
}

