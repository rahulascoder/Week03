package searching;

public class Searching2DMatrix {

    // Method to search for a target value in a 2D sorted matrix
    public static boolean searchMatrix(int[][] matrix, int target) {
        //checking if matrix empty or null
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        //Finding rows and columns
        int rows = matrix.length, cols = matrix[0].length;
        //calculating left and right point
        int left = 0, right = rows * cols - 1;

        //loop for finding target value
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int row = mid / cols, col = mid % cols;

            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return false;
    }

    // Main method
    public static void main(String[] args) {

        //input matrix
        int[][] matrix = {
                {1, 3, 5},
                {7, 10, 11},
                {12, 14, 16}
        };
        //Target that we have to find
        int target = 10;
        System.out.println("Target " + target + " found in matrix: " + searchMatrix(matrix, target));
    }
}
