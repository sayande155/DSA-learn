package array;

import java.util.ArrayList;
import java.util.List;

public class MatrixSpiralOrder {

    public static List<Integer> spiralOrder(int[][] matrix) {
        int row = matrix.length;
        int column = matrix[0].length;
        int top = 0;
        int bottom = row - 1;
        int left = 0;
        int right = column - 1;

        List<Integer> result = new ArrayList<>();

        while (top <= bottom && left <= right) {

            // printing the top
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }
            top++;

            // printing the right
            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            right--;

            // printing the bottom
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    result.add(matrix[bottom][i]);
                }
                bottom--;
            }

            // printing the left
            if(left <= right){
                for(int i = bottom; i >= top; i--){
                    result.add(matrix[i][left]);
                }
                left++;
            }
        }
        return result;
    }

    public static void main(String args[]){
        int matrix[][] = {
            {1,2,3,4},
            {5,6,7,8},
            {9,10,11,12}
        };
        System.out.println(spiralOrder(matrix));
    }
}
