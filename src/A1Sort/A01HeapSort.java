package A1Sort;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

/// 트리 탐색 및 재귀적 호출 (Min Heap 기반 정렬)
public class A01HeapSort {
    public static void main(String[] args) {
        // 정렬 대상 배열
        int[] arr = {7, 6, 5, 8, 3, 5, 9, 1, 6};

        int n = arr.length;

        /// 1. Min Heap 구성 (전체 배열 기준으로 heapify)
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, i, n); // heapify(arr, 부모 인덱스, 유효 길이) 반을 뚝 자른 길이기 때문에 고정
        }

        /// 2. 정렬 수행 (루트와 맨 뒤 교체 → 힙크기 줄이고 heapify)
        for (int i = n - 1; i > 0; i--) {
            // 루트(최솟값)와 마지막 자리 교환
            int tmp = arr[0];
            arr[0] = arr[i];
            arr[i] = tmp;

            // i는 정렬된 마지막 인덱스 → 힙에서 제외
            heapify(arr, 0, i); // heapSize는 i로 감소
        }

        // 최종 결과: 내림차순
        System.out.println(Arrays.toString(arr));
        /// 최초 힙구성 -> nLog(n)
        Queue<Integer> pq = new PriorityQueue<>(Arrays.asList(7, 6, 5, 8, 3, 5, 9, 1, 6));

        System.out.println(pq.poll());
        /// pq.add 할 경우 하향식이 아니 상향식으로 비교하면서 heapify 체크 (높이만큼 올라가니 log(n))

    }

    // 재귀적 heapify 함수 (Min Heap 조건)
    static void heapify(int[] arr, int parent, int heapSize) { //heapSize 쓰는 이유는 마지막 한개는 열외처리 하기 때문
        int smallest = parent;
        int left = 2 * parent + 1;
        int right = 2 * parent + 2;

        // 왼쪽 자식이 존재하고, 더 작으면 교체 후보
        if (left < heapSize && arr[left] < arr[smallest]) {
            smallest = left;
        }

        // 오른쪽 자식이 존재하고, 더 작으면 교체 후보
        if (right < heapSize && arr[right] < arr[smallest]) {
            smallest = right;
        }

        // 작은 값이 자식이면 스왑하고 재귀적으로 내려감
        if (smallest != parent) {
            int tmp = arr[parent];
            arr[parent] = arr[smallest];
            arr[smallest] = tmp;

            heapify(arr, smallest, heapSize); // 재귀 호출
        }
    }
}

/// priority queue = heapify
