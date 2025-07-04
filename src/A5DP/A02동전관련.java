package A5DP;

public class A02동전관련 {
    public static void main(String[] args) {
        Integer[] arr = {1,4,5};
        int target = 13;

        // Greedy로 문제를 풀 경우 :
        // 5*2+1*3 = 5개

        // DP로 풀 경우 :
        // 4*2 + 5*1 = 3개

        // f(n) = (Min(f(n-ni)), f(n-n2))) + 1

            int[] minArr = new int[target + 1];
            for (int i = 1; i <= target; i++) {
                int min = Integer.MAX_VALUE;
                for (int a : arr) {
                    if (i-a >= 0 && minArr[i-a] < min) {
                        min = minArr[i-a];
                    }
                }
                minArr[i] = min + 1;
            }
    }
    // 13이라는 숫자를 만들 수 있는 경우의 수 중 최소값
}
