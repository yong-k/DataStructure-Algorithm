package baekjoon;

// 10718
import java.io.*;
public class B002_10718 {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        /*
        bw.write("강한친구 대한육군\n");
        bw.write("강한친구 대한육군\n");
        */
        bw.write("강한친구 대한육군");
        bw.newLine();
        bw.write("강한친구 대한육군");
        bw.flush();
        bw.close();
    }
}
