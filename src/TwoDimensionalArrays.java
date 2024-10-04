public class TwoDimensionalArrays {
    int[][] arr = {{1, 2, 3},{4, 5, 6},{7, 8, 9}};
    int row_len = arr.length;
    int col_len = arr[0].length;

    public void printAntiDiagonals(int row, int col)
    {
        while(row < row_len && col >= 0)
        {
            System.out.print(arr[row][col] + " ");
            row++;
            col--;
        }
        System.out.println();
    }

    public void antiDiagonalElements()
    {
        //Prints elements that starts on first row
        int i = 0;
        for(int j = 0; j < col_len; j++)
        {
            printAntiDiagonals(i, j);
        }

        //Prints elements that starts on last col
        int j = col_len - 1;
        for(int k = 1; k < row_len; k++)
        {
            printAntiDiagonals(k, j);
        }
    }
}
