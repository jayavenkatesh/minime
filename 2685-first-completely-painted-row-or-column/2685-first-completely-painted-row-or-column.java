import java.util.HashMap;

class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;
        HashMap<Integer, int[]> hm = new HashMap<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                hm.put(mat[i][j], new int[]{i, j});
            }
        }
        int[] rowCounts = new int[rows];
        int[] colCounts = new int[cols];
        for (int i = 0; i < arr.length; i++) {
            int[] pos = hm.get(arr[i]);
            int row = pos[0];
            int col = pos[1];
            rowCounts[row]++;
            colCounts[col]++;
            if (rowCounts[row] == cols || colCounts[col] == rows) {
                return i;
            }
        }
        
        return -1;
    }
}
