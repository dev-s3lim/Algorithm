package A6TwoPointer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class A01TwoPointerBasic {
    public static void main(String[] args) throws IOException {
        // 두 수의 조합
        int[] nums = {7, 8, 9, 2, 4, 5, 1, 3, 6};
        int target = 10;

        List<int[]> myList = new ArrayList<>();

        /*
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    myList.add(new int[]{nums[i], nums[j]});
                }
            }
        }

        // 결과 출력
        for (int[] a : myList) {
            System.out.println(Arrays.toString(a));
        }


 */
        /// end 가 0부터 스타트, 또는 end 가 length - 1 부터 시작하는 경우도 있음
        /// 위 배열 정렬시 1,2,3,4,5,6,7,8,9
        int start = 0;
        int end = nums.length - 1;

        /// **정렬이 필요한 경우 (두수의 합)
        /// **정렬이 필요하지 않을 경우 (구간의 합)

        Arrays.sort(nums); ///-> 복잡도 nlog(n);
        while (start < end) { ///  ** <= 또는 < 경우 2가지 있음
            int total = nums[start] + nums[end];
            if (total == target) {
                myList.add(new int[]{nums[start], nums[end]});
                start++; //또는 end--; 결국 target 찾아감
            }
            else if (total < target){
                start++;
            }
            else if (total > target) {
                end--;
            }
        }

        for (int[] a : myList) {
            System.out.println(Arrays.toString(a));
        }
    }
}
