package baekjoon_step.Step03_loop;

// 10951
import java.util.*;
import java.io.*;
public class B012_10951 {
    public static void main(String[] args) throws NumberFormatException, IOException {
        /*
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        while (sc.hasNextInt()) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            sb.append(a + b).append("\n");
        }
        System.out.println(sb);
        */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        String str;
        // while(br.readLine() != null) {
        while ((str=br.readLine()) != null) {
            // st = new StringTokenizer(br.readLine());
            //--▷ 이렇게 작성하면 위에  while 문에서 br.readLine으로 한 줄 읽고
            //     stringTokenizer에서 br.readLine 쓴거에서 또 한 줄 읽게돼서
            //     nullPointerException 발생함
            st = new StringTokenizer(str);
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(a + b).append("\n");
        }
        System.out.println(sb);
    }
}
