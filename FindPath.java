package FunPrograms;

import java.util.Arrays;

public class FindPath {
    /**
     * 1 - move right
     * 2 - move left
     * 3 - move bottom
     * 4 - move top
     */
    public boolean isPathExists(int n, int m) {
        if (m <1 || n <1)
            return false;
        int[][] path = new int[n][m];

        boolean result = findPath(0, 0, path, 1);

        if (result)
            System.out.println(Arrays.deepToString(path));

        return result;
    }

    private boolean findPath(int n, int m, int[][] path, int t) {
        if (n == path.length-1 && m == path[0].length-1) {
            return path[n][m] == 0 && (t == (n+1) * (m+1));
        }

        if (n <0 || n>= path.length || m<0 || m>=path[0].length) {
            return false;
        }

        boolean result = false;

        if (m < path[0].length-1 && path[n][m+1] == 0) {
            //System.out.println("Move right");
            path[n][m] = 1;
            result = findPath(n, m + 1, path, t + 1);
        }

        if (m >=1 && !result && path[n][m-1] == 0) {
            //System.out.println("Move left");
            path[n][m] = 2;
            result = findPath(n, m-1, path, t+1);
        }

        if (n < path.length-1 && !result && path[n+1][m] == 0) {
            //System.out.println("Move bottom");
            path[n][m] = 3;
            result = findPath(n+1, m, path, t+1);
        }

        if (n >=1 && !result && path[n-1][m] == 0) {
            //System.out.println("Move top");
            path[n][m] = 4;
            result = findPath(n-1, m, path, t+1);
        }

        if (!result)
            path[n][m] = 0;

        return result;
    }

    public static void main(String[] args) {
        FindPath fp = new FindPath();
        System.out.println("isPathExists = " + fp.isPathExists(5, 5));
    }
}
