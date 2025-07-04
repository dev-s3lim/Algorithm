package A3BFS;

import java.util.*;

public class A03인접리스트활용최단거리 {
    static List<List<Integer>> adjList;
    static boolean[] visited;

    public static void main(String[] args) {
        int[][] edges = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};
        int n = 6;

        adjList = new ArrayList<>();

        for (int i = 0; i < 5; i++){
            adjList.add(new ArrayList<>());
        }
        for (int i = 0; i < adjList.size(); i++){
            adjList.get(i).sort(Comparator.naturalOrder());
        }

        Queue<Integer> myQueue = new LinkedList<>();
        int[] d = new int [5];
        int target = 4;

        myQueue.add(1);

        while(!myQueue.isEmpty()){
            int tmp = myQueue.poll();
            for (int a : adjList.get(tmp)){
                if(!visited[a]) {
                    myQueue.add(a);
                    visited[a] = true;
                    d[a] = d[tmp] + 1;
                    if (target == a) break;
                }
            }
        }
        System.out.println("최장거리: " + d[target]);

    }
}

/// 촌수 계산 (백준)