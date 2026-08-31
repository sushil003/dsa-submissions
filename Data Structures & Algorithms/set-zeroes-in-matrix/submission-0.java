class Solution {
    public void setZeroes(int[][] matrix) {
        int rows = matrix.length;
        int columns = matrix[0].length;
        boolean zeroFirstRow = false;
        boolean zeroFirstColumn = false;
        // Check the first row
        for (int column = 0; column < columns; column++) {
            if (matrix[0][column] == 0) {
                zeroFirstRow = true;
            }
        }
        // Check the first column
        for (int row = 0; row < rows; row++) {
            if (matrix[row][0] == 0) {
                zeroFirstColumn = true;
            }
        }
        // Use the first row and column as markers
        for (int row = 1; row < rows; row++) {
            for (int column = 1; column < columns; column++) {
                if (matrix[row][column] == 0) {
                    matrix[row][0] = 0;
                    matrix[0][column] = 0;
                }
            }
        }
        // Set marked cells to zero
        for (int row = 1; row < rows; row++) {
            for (int column = 1; column < columns; column++) {
                if (matrix[row][0] == 0 || matrix[0][column] == 0) {
                    matrix[row][column] = 0;
                }
            }
        }
        if (zeroFirstRow) {
            for (int column = 0; column < columns; column++) {
                matrix[0][column] = 0;
            }
        }
        if (zeroFirstColumn) {
            for (int row = 0; row < rows; row++) {
                matrix[row][0] = 0;
            }
        }
    }
}