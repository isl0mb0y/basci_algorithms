public class SortingAlgorithms {
    public static Integer[] bubbleSort(Integer[] nums) {
        // assigning length of array
        int l = nums.length;

        for (int i = 0; i < l; i++) {
            for (int j = 0; j < l - i - 1; j++) {
                // if current element greater than next element, swap them
                if (nums[j] > nums[j+1]) {
                    int swap = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = swap;
                }
            }
        }

        return nums;
    }
}
