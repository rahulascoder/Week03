package searching;

public class PeakElement {

    // Method to find a peak element
    public static int findPeakElement(int[] arr) {
        //Taking left and right as pointer to find position of term
        int left = 0, right = arr.length - 1;

        while (left <= right) {

            // Calculating middle index to avoid overflow
            int mid = left + (right - left) / 2;

            // Checking if mid is a peak element
            if ((mid == 0 || arr[mid] > arr[mid - 1]) && (mid == arr.length - 1 || arr[mid] > arr[mid + 1])) {
                return mid;
            }

            // If the left neighbor is greater then peak must be on the left side
            if (mid > 0 && arr[mid] < arr[mid - 1]) {
                right = mid - 1;
            }
            // Else peak must be on the right side
            else {
                left = mid + 1;
            }
        }

        return -1;
    }

    // Main method
    public static void main(String[] args) {

        //Input array
        int[] arr = {1, 113, 20, 4, 1, 0};
        //Calling method with arr as parameter
        int peakIndex = findPeakElement(arr);
        System.out.println("Peak element is at index: " + peakIndex);
        System.out.println("Peak element value: " + arr[peakIndex]);
    }
}
