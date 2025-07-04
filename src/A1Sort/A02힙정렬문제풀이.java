package A1Sort;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/// 프로그래머스 명예의 전당
public class A02힙정렬문제풀이 {
    public static void main(String[] args) {
        Queue<Integer> pq = new PriorityQueue<>();

        int[] answer = new int[7];
        int k = 3;
        int[] score = {10, 100, 20, 150, 1, 100, 200};

        for (int i = 0; i < score.length; i++) {
            pq.add(score[i]);

            if (pq.size() > k) {
                answer[i] = pq.poll();
            }

            answer[i] = pq.peek();
        }
        System.out.println(Arrays.toString(answer));
    }
}