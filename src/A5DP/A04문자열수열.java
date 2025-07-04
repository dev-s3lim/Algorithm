package A5DP;

import java.io.*;
import java.util.*;

public class A04문자열수열 {
    /// 백준 -> 가장 긴 증가하는 부분 수열 (11053)
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int [n];

        String[] input = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            int v = Integer.parseInt(input[i]);
            arr[i] = v;
        }

        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 0; i < dp.length; i++) {
            int localMax = Integer.MIN_VALUE;
            boolean check = false;
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && dp[j] > localMax) {
                    localMax = dp[j];
                    check = true;
                }
            }
            if (check) {
                dp[i] = localMax + 1;
            }
        }

        int max = Integer.MIN_VALUE;
        for (int answer : dp) {
            if (answer > max) {
                max = answer;
            }
        }
        System.out.println(max);
    }
}
