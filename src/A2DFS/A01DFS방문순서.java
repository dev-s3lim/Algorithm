package A2DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class A01DFS방문순서 {
    static List<List<Integer>> adjList;
    static boolean[] visited;

    public static void main(String[] args) {
        /// 방문할 수 있는 점이 여러개인경우, 정점번호가 작은 것을 먼저 방문
        /// DFS로 방문 시 방문 순서 : 0 -> 1 -> 3 -> 2 -> 4
            int[][] nodes = {{0,2},{0,1},{1,3},{2,3},{2,4}};
        adjList = new ArrayList<>(); /// 인접리스트(adjList)를 활용해서 인접 노드를 빠르게 접근
        visited = new boolean[5];

        for (int i = 0; i < 5; i++){
            adjList.add(new ArrayList<>());
        }
        /// 인접리스트 만드는 공식
        for (int i = 0; i < nodes.length; i++){
            adjList.get(nodes[i][0]).add(nodes[i][1]); /// 단방향
            adjList.get(nodes[i][1]).add(nodes[i][0]); /// 양방향
        }
        /// 정렬
        for (int i = 0; i < adjList.size(); i++){
            adjList.get(i).sort(Comparator.naturalOrder());
        }

        dfs(0);
    }

    static void dfs (int start) {
        visited[start] = true;
        System.out.println(start);
        /// 인접리스트 순회시 향상된 for문 사용
        for (int a : adjList.get(start)) {
            if (!visited[a]){
                dfs(a);
            }
        }
    }
}
