package A5DP;

public class A01계단관련 {
    /// 지역의 규칙을 찾고, 25의 최댓값 안에 모든 경우의 수가 포함되어 있음
    public static void main(String[] args) {
        int[] arr = {0, 10, 20, 15, 25, 10 ,20};
        int[] maxArr = new int[arr.length];
        maxArr[0] = arr[0];
        maxArr[1] = arr[0] + arr[1];
        maxArr[2] = arr[1] + arr[2];

        for (int i = 2; i < maxArr.length; i++) {
            int a = maxArr[i-2] + arr[i];
            int b = maxArr[i-3] + arr[i-1] + arr[i];
            maxArr[i] = Math.max(a,b);
        }
    }
}
