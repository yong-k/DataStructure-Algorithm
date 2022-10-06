package baekjoon_step.Step07_basicMath1;

/*
고정비용 + (n x 가변비용) = (n x 상품가격)
(n x 상품가격) - (n x 가변비용) = 고정비용
n(상품가격 - 가변비용) = 고정비용
n = 고정비용 / (상품가격 - 가변비용)
--▷ n = a / (c - b)
이건 이익이 나는 지점은 아님
( a / (c - b) ) + 1  ==> 이익 발생하는 판매량

b(가변비용)가 c(상품가격)와 같거나 크다면, 이익 발생 X
*/

import java.io.*;
import java.util.StringTokenizer;
public class B028_1712 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());   //--고정비용
        int b = Integer.parseInt(st.nextToken());   //--가변비용
        int c = Integer.parseInt(st.nextToken());   //--제품가격

        if (b >= c)
            System.out.println(-1);
        else
            System.out.println((a / (c - b)) + 1);
    }
}
