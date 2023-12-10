package СТР50;

public class Matrix {
    public static void main(String[] args) {
        int[][] matrix1 = {
                {3,-1, 2, 5, -2},
                {-1, 2, 3, 5, -2},
        };
        long totalSum = 0;
        for (int[] row : matrix1)
            totalSum += sumIntArrayElementsBetweenFistAndSecondNegativeVal(row);
        System.out.println(totalSum);
    }

    public static long sumIntArrayElementsBetweenFistAndSecondNegativeVal(int[] anArray)
            throws IllegalArgumentException {
        int firstNegElemIndex = -1;
        int secondNegElemIndex = -1;
        for (int i = 0; i < anArray.length; i++) {
            if (anArray[i] < 0 && firstNegElemIndex > -1) {
                secondNegElemIndex = i;
                break;
            }
            if (anArray[i] < 0 && firstNegElemIndex == -1) {firstNegElemIndex = i;}
        }
        if (firstNegElemIndex == -1 || secondNegElemIndex == -1) throw new IllegalArgumentException();
        long sum = 0;
        for (int i = firstNegElemIndex + 1; i < secondNegElemIndex; i++) {
            sum += anArray[i];
        }
        return sum;
    }

}
