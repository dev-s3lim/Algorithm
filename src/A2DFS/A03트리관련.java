package A2DFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class A03트리관련 {
    static List<List<Integer>> adjList;
    static int[] parent;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        /// 트리부모 찾기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        adjList = new ArrayList<>();
        parent = new int [N-1];
        visited = new boolean[N + 1];

        for (int i = 0; i <= N; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < N - 1; i++) {
            String[] input = br.readLine().split(" ");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);

            adjList.get(a).add(b);
            adjList.get(b).add(a);
        }

        dfs(1);
    }

    static void dfs (int start) {
        visited[start] = true;
        for (int a : adjList.get(start)) {
            if(!visited[a]) {
                for (int i = 0; i < adjList.size(); i++){
                    parent[i] = a;
                }
                System.out.println(Arrays.toString(parent));
                dfs(a);
            }
        }
    }
}
