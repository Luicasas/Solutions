class Matrix {
    private final double[][] values;
    private final int numRows;
    private final int numColumns;

    public Matrix(int numRows, int numColumns) {
        this.values = new double[numRows][numColumns];
        this.numRows = numRows;
        this.numColumns = numColumns;
    }

    public int getNumRows() {
        return this.numRows;
    }

    public int getNumColumns() {
        return this.numColumns;
    }

    public double getValue(int row, int column) {
        return this.values[row][column];
    }

    public void setValue(int row, int column, double value) {
        this.values[row][column] = value;
    }

    public Matrix multiply(Matrix a, Matrix b) {
        Matrix matrixToReturn = new Matrix(a.getNumRows(), b.getNumColumns());
        for (int i = 0; i < matrixToReturn.getNumRows(); i++)
            for (int j = 0; j < b.getNumColumns(); j++)
                for (int k = 0; k < a.getNumRows(); k++)
                    matrixToReturn.setValue(i, j, a.getValue(i, k) * b.getValue(k, j));
        return matrixToReturn;
    }

    public Matrix add(Matrix a, Matrix b) {
        Matrix matrixToReturn = new Matrix(a.numRows, b.numColumns);
        for (int i = 0; i < matrixToReturn.numRows; i++) {
            for (int j = 0; j < matrixToReturn.numColumns; j++) {
                matrixToReturn.setValue(i, j, (a.getValue(i, j) + b.getValue(i, j)));
            }
        }
        return matrixToReturn;
    }

    public Matrix subtract(Matrix a, Matrix b) {
        Matrix matrixToReturn = new Matrix(a.numRows, b.numColumns);
        for (int i = 0; i < matrixToReturn.numRows; i++) {
            for (int j = 0; j < matrixToReturn.numColumns; j++) {
                matrixToReturn.setValue(i, j, (a.getValue(i, j) - b.getValue(i, j)));
            }
        }
        return matrixToReturn;
    }

    public void print() {
        for (int i = 0; i < this.numRows; i++) {
            for (int j = 0; j < this.numColumns; j++) {
                System.out.print(this.values[i][j] + " ");
            }
            System.out.println();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        int[][] a = {{-16, -2}, {-32, -4}, {0, 0}};
        int[][] b = {{2, 0}, {5, -3}, {-4, 6}};
        Matrix A = new Matrix(3, 2);
        Matrix B = new Matrix(3, 2);
        Matrix result;
        addNumbersToMatrix(A, a);
        addNumbersToMatrix(B, b);
        System.out.println("Matrix A:");
        A.print();
        System.out.println("\nMatrix B:");
        B.print();

        System.out.println("\nA + B:");
        A = A.add(A, B);
        A.print();
    }

    public static void addNumbersToMatrix(Matrix matrix, int[][] numbers) {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = 0; j < numbers[i].length; j++) {
                matrix.setValue(i, j, numbers[i][j]);
            }
        }
    }
}
