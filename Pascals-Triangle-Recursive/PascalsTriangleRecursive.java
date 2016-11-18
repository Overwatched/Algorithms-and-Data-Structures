/**
 * Recursive implementation of pascals triangle. Prints n amount of rows in pascals triangle.
 * This version prints the pyramid upside down, since the recursions makes it troublesome to
 * print it the other way around.
 */
public class PascalsTriangleRecursive  {

    private long[][] pTriangle;

    /**
     * Constructor makes sure the size of the storage array is set, and
     * runs the printing method.
     * @param n number of rows to be printed.
     */
    public PascalsTriangleRecursive(int n){
        n = n - 1;
        setN(n);
        printPascal(n);
    }

    /**
     * Prints Pascals Triangle to the n:th number.
     * Improved performance by not having to recalculate already calculated values
     * @param n number of rows to be printed
     */

    public void printPascal(int n) {
        int k = n + 1;
        if (n >= 0) {
            while(k != 0){
                System.out.print(binom(n, --k));
            }
            System.out.println();
            printPascal(n - 1);
        }
    }

    /**
     *  Either calculates a value in pascals triangle, or "returns" an already calculated value.
     *  This leads to every value only being calculated once.
     * @param n seen as the row
     * @param k seen as an index in the current row
     * @return value at row n index k
     */
    public long binom(int n, int k){
        long result;

        if (pTriangle[n][k] != 0)
            return pTriangle[n][k];

        if(k==0 || k==n)
            result = 1;
        else if(k == 1 || k == n-1)
            result = n;
        else
            result= binom(n-1, k-1) + binom(n-1, k);
        pTriangle[n][k] = result;
        return result;
    }

    /**
     * Handy method used in order to set the arraysize.
     * @param n arraysize
     */
    private void setN(int n)  {
        pTriangle = new long[n+1][n+1];
    }

}
