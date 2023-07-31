package tony_git.string;

import java.io.*;
public class B_3029 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String curTime = br.readLine();
        String throwTime = br.readLine();

        // curTime == throwTime 같으면 24시간 기다려야하는 거
        // 이거 처리 안하면, 0시간 기다려야한다고 돼서 틀림
        if (curTime.equals(throwTime)) {
            System.out.println("24:00:00");
            return;
        }

        String[] throwTimes = throwTime.split(":");
        String[] curTimes = curTime.split(":");
        int h = Integer.parseInt(throwTimes[0]) - Integer.parseInt(curTimes[0]);
        int m = Integer.parseInt(throwTimes[1]) - Integer.parseInt(curTimes[1]);
        int s = Integer.parseInt(throwTimes[2]) - Integer.parseInt(curTimes[2]);

        if (s < 0) {
            s += 60;
            m--;
        }
        if (m < 0) {
            m += 60;
            h--;
        }
        if (h < 0)
            h += 24;

        System.out.format("%02d:%02d:%02d", h, m, s);
    }
}
