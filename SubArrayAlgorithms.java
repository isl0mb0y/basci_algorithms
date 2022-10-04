public class SubArrayAlgorithms {
    // O(n^3) => cubic
    public int maxConsecutiveSubArraySumCubic(int nums[]) {
        int n = nums.length;
        int best = nums[0];
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                int sum = 0;
                for (int k = i; k <= j; k++) {
                    sum += nums[k];
                }
                best = Math.max(best, sum);
            }
        }

        return best;
    }

    // O(n^2) => quadratic
    public int maxConsecutiveSubArraySumQuadratic(int nums[]) {
        int n = nums.length;
        int best = nums[0];
        for (int i = 0; i < n; i ++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                best = Math.max(best, sum);
            }
        }

        return best;
    }

    // O(n) => linear
    public int maxConsecutiveSubArraySumLinear(int nums[]) {
        int n = nums.length;
        int best = nums[0];
        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum = Math.max(nums[i], nums[i] + sum);
            best = Math.max(best, sum);
        }

        return best;
    }

}
