
import java.io.*;
import java.util.*;
public class T999_practice {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        /*
        * map 사용해서 key로 value가져와서 출력하고 싶음
        * - set에 넣고 → 리스트에 저장해서 정렬
        * - map에 저장하면서 order를 value에 넣음
        * */
        int[] coords = new int[N];
        Set<Integer> set = new HashSet<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            coords[i] = Integer.parseInt(st.nextToken());
            set.add(coords[i]);
        }

        // 정렬
        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);

        // HashMap에 <숫자, 순서>로 key, value 값 넣는다.
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            map.put(list.get(i), i);
        }

        // coords 배열값을 key로 사용하여 map에 저장된 값 출력
        StringBuilder sb = new StringBuilder();
        for (int i : coords)
            sb.append(map.get(i)).append(' ');
        System.out.println(sb);
    }
}

