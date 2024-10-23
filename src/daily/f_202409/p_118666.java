package daily.f_202409;

import java.util.HashMap;

/**
 * 프로그래머스 - 성격 유형 검사하기 (240829)
 * https://school.programmers.co.kr/learn/courses/30/lessons/118666
 * */
public class p_118666 {
    public String solution(String[] survey, int[] choices) {
        /*
        * RT / CF / JM / AN 둘 중 점수 높은 걸로 하면 됨
        * 123이면 왼쪽꺼에 567이면 오른쪽꺼에 점수 추가(|4 - x|)
        * */

        HashMap<Character, Integer> map = new HashMap<>();
        map.put('R', 0);    map.put('C', 0);    map.put('J', 0);    map.put('A', 0);
        map.put('T', 0);    map.put('F', 0);    map.put('M', 0);    map.put('N', 0);

        for (int i = 0; i < survey.length; i++) {
            char c = choices[i] < 4 ? survey[i].charAt(0) : survey[i].charAt(1);
            map.put(c, map.get(c) + Math.abs(4 - choices[i]));
        }

        StringBuilder sb = new StringBuilder();
        sb.append(map.get('R') >= map.get('T') ? 'R' : 'T');
        sb.append(map.get('C') >= map.get('F') ? 'C' : 'F');
        sb.append(map.get('J') >= map.get('M') ? 'J' : 'M');
        sb.append(map.get('A') >= map.get('N') ? 'A' : 'N');
        return sb.toString();
    }
}
