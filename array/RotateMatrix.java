package array;


/*
 * n * n matrix 
 * 
 * Brute : store in a different array : temp[j][n-1-i] = matrix[i][j]
 * 
 * Optimal : Inplace ==> First Transpose -> Then reverse each row
 */
public class RotateMatrix {

    public static void rotateMatrixBrute(int matrix[][]) {
        int n = matrix.length;
        int temp[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                temp[j][n - 1 - i] = matrix[i][j];
            }
        }

        // copying back
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = temp[i][j];
            }
        }
    }

    public static void reverse(int arr[]){
        int i = 0; 
        int j = arr.length-1;
        while(i < j){
            int temp = arr[i];
            arr[i++] = arr[j];
            arr[j--] = temp;
        }
    }

    public static void rotateMatrixOptimal(int matrix[][]){
        int n = matrix.length;
        
        // Transpose of a Matrix 
        for(int i = 0; i < n-1; i++){
            for(int j = i+1; j < n; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        // Reverse each row of matrix
        for(int i = 0 ; i < n; i++){
            reverse(matrix[i]);
        }
    }

    public static void main(String args[]) {
        int matrix[][] = {
                { 1,  2,  3,  4 },
                { 5,  6,  7,  8 },
                { 9,  10, 11, 12 },
                { 13, 14, 15, 16 }
        };
        // rotateMatrixBrute(matrix);
        rotateMatrixOptimal(matrix);
        for (int i[] : matrix) {
            for (int j : i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}
