class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        // Transpose: swap matrix[row][col] with matrix[col][row]
        for (int row = 0; row < n; row++) {
            for (int col = row + 1; col < n; col++) {
                int temp = matrix[row][col];
                matrix[row][col] = matrix[col][row];
                matrix[col][row] = temp;
            }
        }
        // Reverse every row
        for (int[] row : matrix) {
            int left = 0;
            int right = n - 1;
            while (left < right) {
                int temp = row[left];
                row[left] = row[right];
                row[right] = temp;
                left++;
                right--;
            }
        }
    }
}
