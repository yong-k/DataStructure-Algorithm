
import java.io.*;
import java.util.*;

public class T999_practice {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++)
            list.add(Integer.parseInt(br.readLine()));

        Collections.sort(list);
        for (Integer x : list)
            System.out.println(x);
    }
}

