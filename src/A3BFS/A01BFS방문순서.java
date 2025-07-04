package A3BFS;

import java.util.*;

public class A01BFS방문순서 {
    static List<List<Integer>> adjList;
    static boolean[] visited;

    public static void main(String[] args) {
        /// 방문할 수 있는 점이 여러개인경우, 정점번호가 작은 것을 먼저 방문
        /// BFS로 방문 시 방문 순서 : 0 -> 1 -> 2 -> 3 -> 4
        int[][] nodes = {{0,2},{0,1},{1,3},{2,3},{2,4}};

        adjList = new ArrayList<>();
        visited = new boolean[5];

        for (int i = 0; i < 5; i++){
            adjList.add(new ArrayList<>());
        }
        for (int i = 0; i < nodes.length; i++){
            adjList.get(nodes[i][0]).add(nodes[i][1]);
            adjList.get(nodes[i][1]).add(nodes[i][0]);
        }
        for (int i = 0; i < adjList.size(); i++){
            adjList.get(i).sort(Comparator.naturalOrder());
        }

        Queue<Integer> myQueue = new LinkedList<>();
        myQueue.add(0);
        visited[0] = true;
        while(!myQueue.isEmpty()){
            int tmp = myQueue.poll();
            System.out.println(tmp);
            for (int a : adjList.get(tmp)){
                if(!visited[a]) {
                    myQueue.add(a);
                    visited[a] = true; ///Queue에 담는 시점에 true 세팅해야 중복해서 queue에 안담김
                }
            }
        }
    }
}
