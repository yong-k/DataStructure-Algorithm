package tony_git.string;

import java.io.*;
public class B_9046 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int k = 0; k < T; k++) {
            int[] alphabet = new int[26];   //-- 이거 초기화 위치 잘못 놔서 계속 틀렸음
            String s = br.readLine();
            for (int i = 0; i < s.length(); i++) {
                char now = s.charAt(i);
                if (now >= 'a' && now <= 'z')
                    alphabet[now - 'a']++;
            }

            // 가장 많이 나타난 문자 찾기
            int max = Integer.MIN_VALUE;
            for (int x : alphabet) {
                if (max < x)
                    max = x;
            }

            // 많이 나타난 문자 여러 개인지 확인
            int count = 0;
            int maxIdx = 0;
            for (int i = 0; i < alphabet.length; i++) {
                if (alphabet[i] == max) {
                    count++;
                    maxIdx = i;
                }
            }

            if (count == 1)
                sb.append((char)(maxIdx + 'a')).append('\n');
            else
                sb.append('?').append('\n');
        }
        System.out.print(sb);
    }
}
