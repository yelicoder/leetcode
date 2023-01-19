import java.util.Arrays;

public class IncrementSubmatrices2 {
/*
You are given a positive integer n, indicating that we initially have an n x n 0-indexed integer matrix mat filled with zeroes.

You are also given a 2D integer array query. For each query[i] = [row1i, col1i, row2i, col2i], you should do the following operation:

Add 1 to every element in the submatrix with the top left corner (row1i, col1i) and the bottom right corner (row2i, col2i). That is, add 1 to mat[x][y] for for all row1i <= x <= row2i and col1i <= y <= col2i.
Return the matrix mat after performing every query.



Example 1:


Input: n = 3, queries = [[1,1,2,2],[0,0,1,1]]
Output: [[1,1,0],[1,2,1],[0,1,1]]
Explanation: The diagram above shows the initial matrix, the matrix after the first query, and the matrix after the second query.
- In the first query, we add 1 to every element in the submatrix with the top left corner (1, 1) and bottom right corner (2, 2).
- In the second query, we add 1 to every element in the submatrix with the top left corner (0, 0) and bottom right corner (1, 1).
Example 2:


Input: n = 2, queries = [[0,0,1,1]]
Output: [[1,1],[1,1]]
Explanation: The diagram above shows the initial matrix and the matrix after the first query.
- In the first query we add 1 to every element in the matrix.

Constraints:

1 <= n <= 500
1 <= queries.length <= 104
0 <= row1i <= row2i < n
0 <= col1i <= col2i < n
 */

    public int[][] rangeAddQueries(int n, int[][] queries) {

        int[][] a = new int[n][n];

        int[][] aux = new int[n][n];

        for (int i=0; i<queries.length; i++) {
            updateQuery(queries[i][0], queries[i][1], queries[i][2], queries[i][3], n, aux);
        }

        updateMatrix(a, aux, n);

        return a;
    }

    public void updateQuery(int from_x, int from_y,
                            int to_x, int to_y, int n, int aux[][]) {
        // Update top cell
        aux[from_x][from_y]++;

        // Update bottom left cell
        if (to_x + 1 < n)
            aux[to_x + 1][from_y]--;

        // Update bottom right cell
        if (to_x + 1 < n && to_y + 1 < n)
            aux[to_x + 1][to_y + 1]++;

        // Update top right cell
        if (to_y + 1 < n)
            aux[from_x][to_y + 1]--;

        System.out.println(Arrays.deepToString(aux));
    }

    public void updateMatrix(int mat[][],
                 int aux[][], int n)
    {

        // Compute the prefix sum of all columns
        for (int i = 0; i < n; i++)
        {
            for (int j = 1; j < n; j++)
            {
                aux[i][j] += aux[i][j - 1];
            }
        }

        System.out.println(Arrays.deepToString(aux));

        // Compute the prefix sum of all rows
        for (int i = 0; i < n; i++)
        {
            for (int j = 1; j < n; j++)
            {
                aux[j][i] += aux[j - 1][i];
            }
        }

        System.out.println(Arrays.deepToString(aux));

        // Get the final matrix by adding
        // mat and aux matrix at each cell
        for (int i = 0; i < n; i++)
        {
            for (int j = 0; j < n; j++)
            {
                mat[i][j] += aux[i][j];
            }
        }
    }


        public static void main (String[]args){
            int[][] q = {
                    {1, 1, 2, 2},
                    {0, 0, 1, 1}
            };

            IncrementSubmatrices2 o = new IncrementSubmatrices2();
            int[][] a = o.rangeAddQueries(3, q);

            System.out.println(Arrays.deepToString(a));

            q = new int[][]{
                    {0, 0, 1, 1}
            };

            a = o.rangeAddQueries(2,q);

            System.out.println(Arrays.deepToString(a));

        }
    }
