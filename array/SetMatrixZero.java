package array;

import java.util.Arrays;

/*
 * 
 * 1 1 1 1
 * 1 0 0 1
 * 1 1 0 1
 * 1 0 1 1 
 * 
 * if any row or column has 0 then make all elements of that row or column 0
 * 
 * Brute : Fisrt go traverse through whole matrix and if any element need to be change mark it as -1. Then run another loop to replace -1 with 0.
 * 
 * Better : Row and Column Array to keep track of row and column which has 0. 
 * 
 * Optimal : To reduce space complexity we can take matrix[...][0] & matrix[0][...] as row and column array. So we don't need to create extra array.
 * 
 */
public class SetMatrixZero {
    public static void setZeroBetter(int matrix[][]) {
        int n = matrix.length;
        int m = matrix[0].length;
        int row[] = Arrays.copyOf(new int[] { 0 }, n);
        int column[] = Arrays.copyOf(new int[] { 0 }, m);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    row[i] = 1;
                    column[j] = 1;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (row[i] == 1 || column[j] == 1) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public static void setZeroOptimal(int matrix[][]) {
        int n = matrix.length;
        int m = matrix[0].length;
        // int row[] = Arrays.copyOf(new int[] { 0 }, n); ----> row = matrix[...][0]
        // int column[] = Arrays.copyOf(new int[] { 0 }, m); ----> column =
        // matrix[0][...]


        // marking loop
        int col0 = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    // marking row
                    matrix[i][0] = 0;

                    // markign column
                    if (j != 0)
                        matrix[0][j] = 0;
                    else
                        col0 = 0;
                }
            }
        }


        // set zero without matrix[0][...] & matrix[...][0]
        for (int i = n-1; i > 0; i--) {
            for (int j = m-1; j > 0; j--) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if(matrix[0][0] == 0){
            for(int j = 0 ; j < m; j++){
                matrix[0][j] = 0;
            }
        }
        if(col0 == 0){
            for(int i = 0; i < n; i++){
                matrix[i][0] = 0;
            }
        }
    }

    public static void main(String args[]) {
        int matrix[][] = {
                { 1, 1, 1, 1 },
                { 1, 0, 0, 1 },
                { 1, 1, 0, 1 },
                { 1, 0, 1, 1 }
        };
        // setZeroBetter(matrix);
        setZeroOptimal(matrix);
        for (int i[] : matrix) {
            for (int j : i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}
