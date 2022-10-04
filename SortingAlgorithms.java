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

    public static Integer[] mergeSort(Integer[] nums) {
        // if recursion runs into base condition, then return array itself
        if (nums.length == 1) {
            return nums;
        }
        int l = nums.length;
        int leftL = l/2;
        int rightL = l - l/2;


        /* conquering array */

        // array for assigning left half of Array
        Integer[] left = new Integer[leftL];

        // array for assigning right half of Array
        Integer[] right = new Integer[rightL];

        // copy left half of array into left
        System.arraycopy(nums, 0, left, 0, leftL);

        // copy right half of array into right
        System.arraycopy(nums, leftL, right, 0, rightL);

        /* implement merge sort for conquered arrays*/

        // recursive sort left half
        left = mergeSort(left);

        // recursive sort right half
        right = mergeSort(right);

        // merge with sorting left and right
        return merge(left, right);

    }

    public static Integer[] merge(Integer[] left, Integer[] right) {
        int leftLength = left.length;
        int rightLength = right.length;
        Integer[] result = new Integer[leftLength + rightLength];

        int leftIndex = 0, rightIndex = 0, resultIndex = 0;

        /* assign elements of left and right arrays descending order into result array  */
        while (leftIndex < leftLength && rightIndex < rightLength) {
            if (left[leftIndex] <= right[rightIndex]) {
                result[resultIndex++] = left[leftIndex++];
            } else {
                result[resultIndex++] = right[rightIndex++];
            }
        }

        // assign left remaining elements into result array
        while (leftIndex < leftLength) {
            result[resultIndex++] = left[leftIndex++];
        }

        // assign right remaining elements into result array
        while (rightIndex < rightLength) {
            result[resultIndex++] = right[rightIndex++];
        }

        return result;
    }

}
