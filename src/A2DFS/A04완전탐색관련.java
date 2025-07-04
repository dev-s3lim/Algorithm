package A2DFS;

import java.io.*;
import java.util.*;

public class A04완전탐색관련 {
    /// 숫자판 (5x5)
    static int[][] board = new int[5][5];

    /// 중복 없는 6자리 수를 저장할 Set
    static Set<String> resultSet = new HashSet<>();

    /// 상하좌우 이동 좌표 설정
    static int[] dx = {-1, 1, 0, 0}; /// 위, 아래
    static int[] dy = {0, 0, -1, 1}; /// 왼쪽, 오른쪽

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        /// 5x5 숫자판 입력 받기
        for (int i = 0; i < 5; i++) {
            String[] input = br.readLine().split(" ");
            for (int j = 0; j < 5; j++) {
                board[i][j] = Integer.parseInt(input[j]); /// 숫자 저장
            }
        }

        /// 모든 칸에서 DFS 시작
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                dfs(i, j, 0, board[i][j] + ""); /// 시작 좌표, 이동 횟수 0, 현재 숫자 추가
            }
        }

        /// 결과 출력 (중복 없는 6자리 수의 개수)
        System.out.println(resultSet.size());
    }

    /// DFS 메서드 정의
    static void dfs(int x, int y, int depth, String path) {
        /// 종료 조건: 6자리 숫자를 만들었으면 Set에 추가하고 종료
        if (depth == 5) {
            resultSet.add(path); /// 중복 없이 저장됨
            return; /// 6개 되면 안되므로 return
        }

        /// 4방향 탐색
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i]; /// 다음 x좌표
            int ny = y + dy[i]; /// 다음 y좌표

            /// 배열 범위 내에서만 이동
            if (nx >= 0 && nx < 5 && ny >= 0 && ny < 5) {
                dfs(nx, ny, depth + 1, path + board[nx][ny]); /// 재귀 호출로 다음 위치 탐색
            }
        }
    }
}


/// 피로도 - 백트래킹