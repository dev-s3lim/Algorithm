package A2DFS;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class DFSPractice {
    static List<List<Integer>> adjList;
    static boolean[] visited;

    public static void main(String[] args) {
        int[][] nodes = {{0,2},{0,1},{1,3},{2,3},{2,4}};
        adjList = new ArrayList<>();
        visited = new boolean[5];

        for (int i = 0; i < 5; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < nodes.length; i++) {
            adjList.get(nodes[i][0]).add(nodes[i][1]);
            adjList.get(nodes[i][1]).add(nodes[i][0]);

        }

        for (int i = 0; i < adjList.size(); i++) {
            adjList.get(i).sort(Comparator.naturalOrder());
        }

        dfs(0);
    }

    static void dfs (int start) {
        visited[start] = true;
        System.out.println();
        for (int a : adjList.get(start)) {
            if (!visited[a]) {
                dfs (a);
            }
        }
    }
}
