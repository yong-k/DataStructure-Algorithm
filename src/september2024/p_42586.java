package september2024;

import java.util.ArrayList;
import java.util.List;

/**
 * 프로그래머스 - 기능개발 (240829)
 * https://school.programmers.co.kr/learn/courses/30/lessons/42586
 * */
public class p_42586 {
    public int[] solution(int[] progresses, int[] speeds) {
        /*
        100-93 = 7 / 1 = 7일
        100-30 = 70 / 30 = 2일 + 70 % 30 > 0 ==> 3일
        100-55=45 / 5 = 9일
        [7,3,9] ==> 7일째에 2개 배포 , 9일째에 1개 배포 [2,1]
        7보다 큰거 만날 때까지 쭉 가면서 count++, 큰거만나면 list.add()
        * */

        // 기능별 완료일 계산
        int[] completeDate = new int[progresses.length];
        for (int i = 0; i < completeDate.length; i++) {
            int remains = 100 - progresses[i];
            completeDate[i] = (remains / speeds[i]) + ((remains % speeds[i] > 0) ? 1 : 0);
        }

        List<Integer> list = new ArrayList<>();
        int prev = completeDate[0];
        int count = 0;
        for (int c: completeDate) {
            if (prev < c) {
                list.add(count);
                prev = c;
                count = 0;
            }
            count++;
        }
        if (count != 0) list.add(count);

        int[] result = new int[list.size()];
        for (int i = 0; i < result.length; i++)
            result[i] = list.get(i);

        return result;
    }
}
