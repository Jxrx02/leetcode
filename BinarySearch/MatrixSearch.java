package BinarySearch;

public class MatrixSearch {
  public static void main(String[] args) {
    int[][] matrix = {
            {1}
    };
    int target = 2;

    boolean result = searchMatrix(matrix, target);
    System.out.println("Target found: " + result);
  }

  public static boolean searchMatrix(int[][] matrix, int target) {
    if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
      return false;
    }

    int rows = matrix.length;
    int cols = matrix[0].length;

    int row = 0;
    int col;
    for (int i = 0; i <rows; i++) {
      if(target > matrix[i][cols-1])
      {
        if(target == matrix[i][cols-1])
          return true;
        row++;
      }
    }
    System.out.println(row);

    try{
      for (int i = 0; i < matrix[row].length; i++) {
        if(target==matrix[row][i]) return true;
      }
    }
    catch (Exception e){
      return false;
    }

    return false;
  }


}
