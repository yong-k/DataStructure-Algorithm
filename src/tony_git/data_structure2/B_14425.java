package tony_git.data_structure2;

import java.util.*;
public class B_14425 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        Set<String> set = new HashSet<>();
        int answer = 0;

        for (int i = 0; i < N; i++)
            set.add(sc.next());

        for (int i = 0; i < M; i++) {
            if (set.contains(sc.next()))
                answer++;
        }
        System.out.println(answer);
    }
}
