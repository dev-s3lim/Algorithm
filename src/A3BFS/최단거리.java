package A3BFS;

import java.util.*;

public class 최단거리 {
    static List<List<Integer>> adjList;
    static boolean[] visited;

    public static void main(String[] args) {
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


        /// Queue 안에 Integer가 아닌 int 배열을 담아서 0번째는 노드번호, 1번째는 distance 설계 가능
        Queue<Integer> myQueue = new LinkedList<>();
        int[] d = new int [5];
        int target = 4;

        myQueue.add(0);
        visited[0] = true;
        while(!myQueue.isEmpty()){
            int tmp = myQueue.poll();
            for (int a : adjList.get(tmp)){
                if(!visited[a]) {
                    myQueue.add(a);
                    visited[a] = true;
                    d[a] = d[tmp] + 1;
                    /// 찾고자 하는  target이 정해져있으면
                    if (target == a) break;
                }
            }
        }
        System.out.println("최단거리: " + d[target]);

//      Queue안에 Integer가 아니라 int[]을 담아서 0번째는 노드번호, 1번째는 distance설계 가능.
        Queue<int[]> myQueue2 = new LinkedList<>();
        int[] d2 = new int[5];
        int target2 = 4;
        myQueue2.add(new int[]{0, 0});
        visited[0]=true;
        while (!myQueue2.isEmpty()){
            int[] temp = myQueue2.poll();
            for (int a2 : adjList.get(temp[0])){
                if(!visited[a2]){
                    myQueue2.add(new int[]{a2, temp[1]+1});
                    visited[a2] = true; //queue에 담는시점에 true세팅해야지, 중복해서 queue에 안담김.
//                    만약에 찾고자하는 target이 정해져 있으면 break;
                    if(target==a2){
                        break;
                    }
                }
            }
        }
        System.out.println(d2[target2]);
    }
}
