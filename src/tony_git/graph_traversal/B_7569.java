package tony_git.graph_traversal;

// https://yongku.tistory.com/entry/%EB%B0%B1%EC%A4%80-%EC%95%8C%EA%B3%A0%EB%A6%AC%EC%A6%98-%EB%B0%B1%EC%A4%80-7569%EB%B2%88-%ED%86%A0%EB%A7%88%ED%86%A0-%EC%9E%90%EB%B0%94Java

import java.util.*;

public class B_7569 {
    static int M, N, H;
    static int[][][] box;
    static Queue<Tomato> queue;

    // 상하좌우 위아래
    static int[] dx = {0, 0, -1, 1, 0, 0};
    static int[] dy = {1, -1, 0, 0, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        M = sc.nextInt();
        N = sc.nextInt();
        H = sc.nextInt();
        box = new int[H][N][M];
        queue = new LinkedList<>();

        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    box[i][j][k] = sc.nextInt();

                    // 토마토 익은거면, 바로 queue에 넣음
                    if (box[i][j][k] == 1)
                        queue.add(new Tomato(i, j, k));
                }
            }
        }

        BFS();

        // 토마토가 익은 일수 중 최댓값
        int answer = Integer.MIN_VALUE;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    // 안 익은 토마토가 있다면, -1 출력
                    if (box[i][j][k] == 0) {
                        System.out.println(-1);
                        return;
                    }
                    answer = Math.max(answer, box[i][j][k]);
                }
            }
        }

        // 익은 날짜: box[i][j] 익은 토마토 기준으로 1부터 시작했으니까, -1 해줌
        System.out.println(answer - 1);
    }

    static void BFS() {
        while (!queue.isEmpty()) {
            Tomato tomato = queue.poll();
            for (int k = 0; k < 6; k++) {
                int x = tomato.x + dx[k];
                int y = tomato.y + dy[k];
                int z = tomato.z + dz[k];
                if (x >= 0 && y >= 0 && z >= 0 && x < N && y < M && z < H) {
                    if (box[z][x][y] == 0){
                        queue.add(new Tomato(z, x, y));
                        box[z][x][y] = box[tomato.z][tomato.x][tomato.y] + 1;   // 이전 토마토 익은 날짜 + 1
                    }
                }
            }
        }
    }
}

class Tomato {
    int z;
    int x;
    int y;

    public Tomato(int z, int x, int y) {
        this.z = z;
        this.x = x;
        this.y = y;
    }
}
