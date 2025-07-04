package A7BinarySearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class A02이분탐색활용문제 {
    public static void main(String[] args) throws IOException {

        /*
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] stArr = br.readLine().split(" ");
//        485
        int target = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        for (int i=0; i<stArr.length; i++){
//            120 110 140 150
            arr[i] = Integer.parseInt(stArr[i]);
        }
        int min = 1;
        int max = Arrays.stream(arr).max().getAsInt();
        int answer = 0;
//        484
        int totalMax = 0;
        for (int i=min; i<=max; i++){
            int total = 0;
            for (int j=0; j<arr.length; j++){
                int temp = arr[j] > i ? i : arr[j];
                total+=temp;
            }
            if(total < target){
                totalMax=total;
                answer=i;
            } else if (total==target) {
                totalMax=total;
                answer=i;
                break;
            } else if(total > target){
                break;
            }
        }
        System.out.println(answer);

         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());               // 부서 수
        String[] input = br.readLine().split(" ");             // 요청 예산 배열
        int M = Integer.parseInt(br.readLine());               // 총 예산

        int[] budget = new int[N];
        for (int i = 0; i < N; i++) {
            budget[i] = Integer.parseInt(input[i]);
        }

        int start = 0;
        int end = 0;
        for (int b : budget) {
            end = Math.max(end, b);  // 최대 요청 금액 = 상한액의 최댓값
        }

        int result = 0;

        while (start <= end) {
            int mid = (start + end) / 2;  // ✅ 핵심 수정

            long total = 0;
            for (int b : budget) {
                total += Math.min(b, mid);  // mid보다 큰 요청은 자르고 합산
            }

            if (total > M) {
                end = mid - 1;  // 예산 초과 → 상한액 줄이기
            } else {
                result = mid;   // 예산 가능 → 일단 저장하고 키워보기
                start = mid + 1;
            }
        }

        System.out.println(result);  // 최종 상한액 출력
    }
}

/// 백준 -> 과자 나눠주기 (answer를 찾은 후에도 계속 탐색)
/// 백준 -> 입국 심사
