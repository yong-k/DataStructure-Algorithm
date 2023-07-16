package codingTestStudy.week1;

import java.util.*;
public class B_11651 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        List<Coordinate> list = new ArrayList<>();

        for (int i = 0; i < N; i++)
            list.add(new Coordinate(sc.nextInt(), sc.nextInt()));

        Collections.sort(list, (o1, o2) -> {
            if (o1.y == o2.y)
                return o1.x - o2.x;
            return o1.y - o2.y;
        });

        StringBuilder sb = new StringBuilder();
        for (Coordinate c : list)
            sb.append(c.x + " " + c.y).append('\n');
        System.out.println(sb);
    }

    static class Coordinate {
        int x;
        int y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
