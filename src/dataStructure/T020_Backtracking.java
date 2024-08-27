package dataStructure;// backtracking 기법
// 제약 조건 만족 문제에서 해를 찾기 위해서
// 후보군을 상태공간트리로 만든 다음에 (직접 트리 형태로 코드짜는 거 ㄴㄴ)
// 조건을 체크하는 Promising 기법과
// 조건에 맞지 않는 경우, 관련된 후보는 싹 다 제거하는 Pruning(가지치기) 기법
// 이 때, 후보군은 DFS 방식으로 확인한다.

// 대표적 문제: N Queen 문제

import java.util.ArrayList;

public class T020_Backtracking {

    // 조건에 맞는지를 검사하는 핵심 루틴 메서드 (promising)
    // candidate: 현재까지의 퀸 위치 정보 리스트
    // currentCol: 지금 선택된 해당 인덱스 번호
    public boolean isAvailable(ArrayList<Integer> candidate, Integer currentCol) {
        Integer currentRow = candidate.size();
        //-- 현재 0행과 1행에 퀸이 저장되어 있다면 size는 2라서 2행을 조사할 수 있음
        //   현재 0, 1, 2행에 퀸이 저장되어 있다면 size는 3이라서 3행을 조사할 수 있음

        for (int i = 0; i < currentRow; i++) {
            // 수평 조건 || 대각선 조건
            // candidate.get(i) => 해당 행에 대한 퀸의 위치 나옴
            // |퀸의 컬럼 위치 - 현재 컬럼 위치| == 현재row - 해당 퀸의 행의 값
            if ((candidate.get(i) == currentCol) || (Math.abs(candidate.get(i) - currentCol) == currentRow - i))
                return false;
        }
        return true;
    }

    // N: N x N 배열에 N개의 queen 을 놓음
    // currentRow: dfsFunc은 재귀적으로 처리될 것이기 때문에 현재 체크해야 될 행 나타내는 변수
    // currentCandidate: currentRow 보다 이전 row들에서의 퀸의 위치 정보를 저장하고 있음
    public void dfsFunc(Integer N, Integer currentRow, ArrayList<Integer> currentCandidate) {

        // 전체 행을 다 돌고, 전체 행에서 알맞은 queen 의 위치를 찾았다는 의미
        //--==>> 결과 출력해주고 끝냄
        if (currentRow == N) {
            System.out.println(currentCandidate);
            return;
        }

        for (int i = 0; i < N; i++) {
            // isAvailable()의 매개변수로 기존의 퀸들의 위치와 지금 체크할 위치를 넘겨줌
            if (this.isAvailable(currentCandidate, i) == true) {
                currentCandidate.add(i);
                this.dfsFunc(N, currentRow + 1, currentCandidate);
                //-- dfsFunc()으로 다시 그 다음 줄 체크

                // this.dfsFunc() 돌다가 currentRow == N 이면 출력하고 끝나겠지만,
                // 조건에 부합하는게 없다면, void형을 return 하기 때문에 이 아랫줄로 내려오게 된다.
                //--▷ 가지치기 해줘야 한다.
                //==> 맨 마지막에 퀸으로 설정한 것의 이하는 볼 필요 없다는 의미로
                //    해당 candidate를 빼주기만 하면 된다.
                /*   ex)
                0,0
                         1,2     에 퀸을 놓은 상태이고,
                2,0 2,1, 2,2 2,3 → 검사했더니 다 퀸을 놓을 수 없음

                ==> 그러면 다시 그 전으로 돌아가서 (1,2)에 놓인 퀸 자체를 삭제하고,
                    다시 그 위에서부터 처리를 한다.
                */

                // 가지치기(pruning)
                currentCandidate.remove(currentCandidate.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        T020_Backtracking nQueen = new T020_Backtracking();
        nQueen.dfsFunc(4, 0, new ArrayList<Integer>());
    }
}
