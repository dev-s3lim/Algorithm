package A6TwoPointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class A02수열의범위 {
    /// 숫자의 표현 - 프로그래머스
    /*
    public static void main(String[] args) {
        int n = 15;
        int start = 1;
        int end = start;
        int total = 1;
        int cnt = 0;

        while (start <= end && end <= n) {
            if (total == n) {
                cnt++;
                total -= start;
                start++;
            }
            else if (total < n){
                end++;
                total += end;
            }
            else {
                total -= start;
                start++;
            }
        }

        System.out.println(cnt);
        }
     */
    /// 연속된 부분 수열의 합
    public static void main(String[] args) {
        int[] sequence = {1, 1, 1, 2, 3, 4, 5};
        int k = 5;
        int min = Integer.MAX_VALUE;

        int start = 1;
        int end = start;
        int total = 1;
        int[] answer = new int[0];
        List<int[]> tmp = new ArrayList<>();

        while (start <= end && end <= k) {
            if (total == k) {
                tmp.add(new int[] {sequence [start], sequence[end]});
                total -= start;
                start++;
            }
            else if (total < k){
                end++;
                total += end;
            }
            else {
                total -= start;
                start++;
            }

            if (tmp.size() < min) {
                min = tmp.size();
            }
        }

        System.out.println(Arrays.toString(answer));
    }
}
