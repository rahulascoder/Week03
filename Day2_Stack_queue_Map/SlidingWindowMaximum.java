import java.util.Deque;
import java.util.LinkedList;

class SlidingWindowMaximum {

    //method to find maximum of sliding window
    public static int[] maxSlidingWindow(int[] nums, int k) {
        // Return empty array if input is empty
        if (nums.length == 0) return new int[0];

        int n = nums.length;
        // Array to store maximums for each window
        int[] result = new int[n - k + 1];
        // Deque to store indices of elements
        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            // Removing elements from the front if they are out of the current window bounds
            if (!deque.isEmpty() && deque.peek() < i - k + 1) {
                // Remove the front element as it is no longer in the window
                deque.poll();
            }

            // Removing elements from the back if they are smaller than the current element
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                // Remove the smaller elements from the back
                deque.pollLast();
            }

            // Add the current element index to the deque
            deque.offer(i);

            // Store the maximum element in the result array once we have a full window
            if (i >= k - 1) {
                // The front of the deque is the maximum
                result[i - k + 1] = nums[deque.peek()];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        // Window size
        int k = 3;
        int[] result = maxSlidingWindow(nums, k);

        // Printing the result array containing maximums for each sliding window
        for (int max : result) {
            System.out.print(max + " ");
        }
    }
}