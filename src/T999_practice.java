import java.io.*;
import java.util.*;
public class T999_practice {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        /*   문자열 길이
         * a 1
         * b       1
         * c    1
         * d
         * */
        int[][] arr = new int[26][str.length() + 1];
        for (int i = 0; i < str.length(); i++) {
            arr[str.charAt(i) - 'a'][i]++;
        }

        int q = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            char c = st.nextToken().charAt(0);
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            int sum = 0;
            for (int j = s; j <= e; j++) {
                sum += arr[c - 'a'][j];
            }
            sb.append(sum).append('\n');
        }
        System.out.print(sb);
    }
}
