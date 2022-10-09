package baekjoon_step.Step07_basicMath1;

import java.io.*;
public class B032_2775 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] apt = new int[15][15];

        for (int i = 1; i < apt.length; i++)
            apt[0][i] = i;

        for (int j = 1; j < apt.length; j++) {
            for (int k = 1; k < apt[j].length; k++) {
                apt[j][k] = apt[j][k-1] + apt[j-1][k];
            }
        }

        int loop = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < loop; i++) {
            int floor = Integer.parseInt(br.readLine());
            int room = Integer.parseInt(br.readLine());
            sb.append(apt[floor][room] + "\n");
        }
        System.out.print(sb);
    }
}
