/**
 * Created By Islombek Mamatkulov
 * Date: 04/10/2022
 */
public class SortingAlgorithms {
    public static int[] bubbleSort(int[] nums) {
        // assigning length of array
        int l = nums.length;

        for (int i = 0; i < l; i++) {
            for (int j = 0; j < l - i - 1; j++) {
                // if current element greater than next element, swap them
                if (nums[j] > nums[j+1]) {
                    swap(nums, j, j+1);
                }
            }
        }

        return nums;
    }

    public static int[] selectionSort(int[] nums) {
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
            swap(nums, i, minIndex);
        }

        return nums;
    }

    // 100,-2, 45, 0, -9, 200, 11, -9, 9
    public static int[] insertionSort(int[] nums) {
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

    public static int[] mergeSort(int[] nums) {
        // if recursion runs into base condition, then return array itself
        if (nums.length == 1) {
            return nums;
        }
        int l = nums.length;
        int leftL = l/2;
        int rightL = l - l/2;


        /* conquering array */

        // array for assigning left half of Array
        int[] left = new int[leftL];

        // array for assigning right half of Array
        int[] right = new int[rightL];

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

    public static int[] merge(int[] left, int[] right) {
        int leftLength = left.length;
        int rightLength = right.length;
        int[] result = new int[leftLength + rightLength];

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

    public static void quickSort(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
    }

    public static void quickSort(int[] nums, int start, int end) {
        if (start < end) {
            // identifying pivot index
            int pivotIndex = partition(nums, start, end);
            /* divide and conquer*/
            quickSort(nums, start, pivotIndex - 1);
            quickSort(nums, pivotIndex + 1, end);
        }
    }

    public static int partition(int[] nums, int start, int end) {
        // declaring pointer
        int pointer = start;
        // let's consider that pivot value is the last element of array
        int pivotValue = nums[end];

        // partitioning
        for (int i = start; i < end; i++) {
            // if current value is lesser than pivot value, then swap it with pointer element, and increment pointer
            if (nums[i] < pivotValue) {
                swap(nums, i, pointer);
                pointer++;
            }
        }

        // place the end element onto the index where all left elements are lesser than pivot value and all right elements are greater than pivot value
        swap(nums, pointer, end);

        return pointer;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


}
