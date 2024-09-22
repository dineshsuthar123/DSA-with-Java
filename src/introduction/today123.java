package introduction;

public class today123 {
    public int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int[][] result = new int[rows * cols][2];
        int[] directionX = { 0, 1, 0, -1 };
        int[] directionY = { 1, 0, -1, 0 };
        int direction = 0;
        int stepSize = 1;
        int x = rStart, y = cStart;
        int index = 0;

        result[index++] = new int[] { x, y };

        while (index < rows * cols) {
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < stepSize; j++) {
                    x += directionX[direction];
                    y += directionY[direction];
                    if (x >= 0 && x < rows && y >= 0 && y < cols) {
                        result[index++] = new int[] { x, y };
                    }
                }
                direction = (direction + 1) % 4;
            }
            stepSize++;
        }

        return result;
    }

    public static void main(String[] args) {
        today123 sol = new today123();

        int[][] result1 = sol.spiralMatrixIII(1, 4, 0, 0);
        printResult(result1);

        int[][] result2 = sol.spiralMatrixIII(5, 6, 1, 4);
        printResult(result2);
    }

    private static void printResult(int[][] result) {
        for (int i = 0; i < result.length; i++) {
            System.out.print("[" + result[i][0] + "," + result[i][1] + "] ");
        }
        System.out.println();
    }
}
