package codingTestStudy.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B_16434_not {
    static long curAtk;  // 용사 공격력
    static long[][] dungeon;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());       // 방의 개수
        curAtk = Integer.parseInt(st.nextToken());
        dungeon = new long[N][3];
        long maxHp = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            dungeon[i][0] = Long.parseLong(st.nextToken());   // 방 번호
            dungeon[i][1] = Long.parseLong(st.nextToken());   // 공격력
            dungeon[i][2] = Long.parseLong(st.nextToken());   // 생명력
            maxHp = Math.max(maxHp, dungeon[i][2]);
        }

        long startHp = 1;
        long endHp = 999999000001L * N;
        long answer = 0;
        while (startHp <= endHp) {
            /*
            * 게임 시작해서
            * 통과 했으면 hp 줄여보기 → endHp = mid - 1;
            * 죽었으면 → startHp = mid + 1;
            **/
            long midHp = (startHp + endHp) / 2;
            boolean life = goDungeon(midHp);
            if (life) {
                endHp = midHp - 1;
                answer = midHp;
            } else {
                startHp = midHp + 1;
            }
        }
        System.out.println(answer);
    }

    static boolean goDungeon(long maxHp) {
        /*
         * 1번방: 몬스터(공격력 atk, 생명력 hp)
         * 2번방: 포션(용사 공격력+atk, 생명력+hp)
         **/
        // dungeon 배열 초기화
        long[][] miniDungeon = new long[dungeon.length][];
        for (int i = 0; i < dungeon.length; i++)
            miniDungeon[i] = Arrays.copyOf(dungeon[i], dungeon[i].length);

        // 공격력 초기화
        long atk = curAtk;
        long hp = maxHp;
        for (int i = 0; i < miniDungeon.length; i++) {
            if (miniDungeon[i][0] == 1) {
                while (miniDungeon[i][2] > 0 ) {
                    // 용사 공격
                    miniDungeon[i][2] -= atk;
                    if (miniDungeon[i][2] <= 0)
                        break;
                    // 몬스터 공격
                    hp -= miniDungeon[i][1];
                    if (hp <= 0)
                        return false;
                }
            } else {
                atk += miniDungeon[i][1];
                hp = Math.min(hp + miniDungeon[i][2], maxHp);
            }
        }
        return true;
    }
}
