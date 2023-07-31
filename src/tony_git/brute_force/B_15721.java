package tony_git.brute_force;

import java.io.*;
public class B_15721 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int A = Integer.parseInt(br.readLine());    // 게임 진행하는 사람수
        int T = Integer.parseInt(br.readLine());    // 구하고자 하는 번째
        int n = Integer.parseInt(br.readLine());    // 0:뻔, 1:데기

        // 뻔, 데기 각각 count 세고, 마지막에 그거 더해서 -1 하고 %A 해주면 됨
        int zeroCnt = 0;    // 뻔 count
        int oneCnt = 0;     // 데기 count
        int cycle = 2;      // 뻔-데기 반복해줄 횟수
        // 뻔-데기-뻔-데기-뻔(xN번)-데기(xN번)을 cycle로 반복
        while(true) {
            // 뻔-데기-뻔-데기
            for (int i = 0; i < 4; i++) {
                if (i % 2 == 0)
                    zeroCnt++;
                else
                    oneCnt++;

                if (n == 0 && zeroCnt == T || n == 1 && oneCnt == T) {
                    System.out.println((zeroCnt + oneCnt - 1) % A);
                    return;
                }
            }

            // 뻔 cycle 반복
            for (int i = 0; i < cycle; i++) {
                zeroCnt++;
                if (n == 0 && zeroCnt == T) {
                    System.out.println((zeroCnt + oneCnt - 1) % A);
                    return;
                }
            }

            // 데기 cycle 반복
            for (int i = 0; i < cycle; i++) {
                oneCnt++;
                if (n == 1 && oneCnt == T) {
                    System.out.println((zeroCnt + oneCnt - 1) % A);
                    return;
                }
            }
            cycle++;
        }
    }
}
