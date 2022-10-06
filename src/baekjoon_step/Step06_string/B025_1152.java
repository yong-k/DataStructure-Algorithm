package baekjoon_step.Step06_string;

import java.io.*;
import java.util.StringTokenizer;

public class B025_1152 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        /*
        String str = (br.readLine()).trim();
        // **split() 사용했을 경우에는 공백 입력하면 1로 나오는거 처리해줘야 함
        if (str.isEmpty()) {
            System.out.println("0");
            return;
        }
        String[] arr = str.split(" ");
        System.out.println(arr.length);
        */

        StringTokenizer st = new StringTokenizer(br.readLine());
        System.out.println(st.countTokens());
    }
}
