package daily.f_202409;

import java.util.HashMap;

/**
 * 프로그래머스 - 달리기 경주 (240827)
 * https://school.programmers.co.kr/learn/courses/30/lessons/178871
 * */
public class p_178871 {
    public String[] solution(String[] players, String[] callings) {
        // player이름, 현재 순위(0부터 시작)
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < players.length; i++)
            map.put(players[i], i);

        for (String player : callings) {
            String prevPlayer = players[map.get(player) - 1];

            // players 배열 갱신
            players[map.get(player)] = prevPlayer;
            players[map.get(player) - 1] = player;

            // map 갱신
            map.put(prevPlayer, map.get(player));
            map.put(player, map.get(player) - 1);
        }
        return players;
    }
}
