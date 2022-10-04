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

    public static Integer[] selectionSort(Integer[] nums) {
        int l = nums.length;

        for (int i = 0; i < l - 1; i++) {
            int minIndex = i;

            // finding min element of sub array
            for (int j = i + 1; j < l; j++) {
                if (nums[j] < nums[minIndex]) {
                    minIndex = j;
                }
            }

            // shifting min elements to left with swapping
            int swap = nums[i];
            nums[i] = nums[minIndex];
            nums[minIndex] = swap;
        }

        return nums;
    }

    // 100,-2, 45, 0, -9, 200, 11, -9, 9
    public static Integer[] insertionSort(Integer[] nums) {
        int l = nums.length;

        for (int i = 1; i < l; i++) {

            // selecting second element of array for inserting
            int selectedElement = nums[i];
            int j = i - 1;

            // if selectedElement is lesser than previous element continue shifting to right previous element to right
            while (0 <= j && selectedElement < nums[j]) {
                nums[j + 1] = nums[j];
                j--;
            }

            // after shifting greater elements to right,
            // insert the selected element after the first element lesser than selected element
            nums[j + 1] = selectedElement;
        }

        return nums;
    }

}
