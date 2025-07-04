package A6TwoPointer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class A03두수의합또는차 {
    public static void main(String[] args) throws IOException {
        /// 두 용액
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int [N];
        String[] input = br.readLine().split(" ");

        for (int i = 0; i < N; i++) {
            int C = Integer.parseInt(input[i]);
            arr[i] = C;
        }

        System.out.println(Arrays.toString(arr));

        /// 수 고르기 (백준 2230)
        /// 1. 정렬
        /// 2. <=
        /// 3. end를 어디서 시작할 것인가. (둘다 0으로 설정하고 풀이하면 됨)
        /// start가 늘고, end가 줄어들면 차가 줄어들기 때문
    }
}
