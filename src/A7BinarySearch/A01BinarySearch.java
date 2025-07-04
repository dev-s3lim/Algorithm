package A7BinarySearch;

import java.io.IOException;
import java.util.Arrays;

public class A01BinarySearch {
    public static void main(String[] args) throws IOException {
        // 정렬된 배열 (이분 탐색의 기본 조건)
        // int[] arr = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};
/*
        // 찾고 싶은 기준값 (보다 큰 값을 찾을 것)
        int target = 17;

        // 정답 초기값: 인덱스 기준 (못 찾으면 -1)
        int answer = -1;

        // 이분 탐색용 포인터
        int start = 0;
        int end = arr.length - 1;

        // 이분 탐색 실행
        while (start <= end) {
            // 1. 중간 인덱스 계산
            int mid = (start + end) / 2;

            // 2. 중간 값이 target보다 크면 → 정답 후보 저장하고 왼쪽 탐색
            if (arr[mid] > target) {
                answer = mid;     // 일단 저장
                end = mid - 1;    // 더 왼쪽에 더 작은 값이 있을 수 있음
            }

            // 3. 중간 값이 target보다 작거나 같으면 오른쪽으로 이동
            else {
                start = mid + 1;
            }
        }

        // 결과 출력
        if (answer != -1) {
            System.out.println("타겟 " + target + "보다 큰 값 중 가장 작은 값: " + arr[answer] + " (인덱스: " + answer + ")");
        } else {
            System.out.println("타겟보다 큰 값이 존재하지 않습니다.");
        }
    }
   */
        int[] arr = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};
        // target이 arr에 있다면 index 값을 리턴하고, arr에 없다면 있어야할 자리 index를 return
        int target = 2;
        int answer = -1;
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (target == arr[mid]) {
                answer = mid;
                /// 조건에 맞는 값을 찾았어도 최소값, 최대값을 위해 이분 탐색을 계속 진행할 수 있음
                break;
            }
            else if (target > arr [mid]) {
                start = mid + 1;
            }
            else {
                end = mid - 1;
                /// 조건에 딱 맞는 값이 없을수도 있는 경우
                // answer = mid;
            }
        }
    }
}