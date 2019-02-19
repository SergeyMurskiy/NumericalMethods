package Tools;

public class Tools {
    //Матричная норма бесконечность
    public static double matrixNormaInfinity(double[][] matrix) {
        double sum;
        double result = 0;
        for (int i = 0; i < matrix.length; i++) {
            sum = 0;
            for (int j = 0; j < matrix[0].length; j++) {
                sum += Math.abs(matrix[i][j]);
            }
            if (sum > result) {
                result = sum;
            }
        }
        return result;
    }

    //Матричная норма 1
    public static double matrixNormaOne(double[][] matrix) {
        double sum;
        double result = 0;
        for (int j = 0; j < matrix[0].length; j++) {
            sum = 0;
            for (int i = 0; i < matrix.length; i++) {
                sum += Math.abs(matrix[i][j]);
            }
            if (sum > result) {
                result = sum;
            }
        }
        return result;
    }

    //Метод Гаусса(приведение матрицы к треугольному виду)
    public static double[][] gauss(double[][] inputMatrix) {
        double[][] matrix = new double[inputMatrix.length][inputMatrix[0].length];
        for (int i = 0; i < inputMatrix.length; i++) {
            for (int j = 0; j < inputMatrix[0].length; j++) {
                matrix[i][j] = inputMatrix[i][j];
            }
        }

        double tmp;
        for (int k = 0; k < matrix.length; k++) {
            tmp = matrix[k][k];
            for (int j = k; j < matrix[0].length; j++) {
                matrix[k][j] /= tmp;
            }

            double tmp1;
            for (int i = k+1; i < matrix.length; i++) {
                tmp1 = matrix[i][k];
                for (int j = k; j < matrix[0].length; j++) {
                    matrix[i][j] -= tmp1 * matrix[k][j];
                }
            }
        }
        return matrix;
    }

    //Решение систем линейных уравнений методом Гаусса
    public static double[] gaussSystemResolve(double[][] matrix) {
        double[][] workMatrix = gauss(matrix);
        double[] result = new double[matrix.length];
        double sum;
        for (int i = matrix.length-1; i >= 0; i--) {
            sum = 0;
            for (int j = i+1; j < matrix.length; j++) {
                sum += workMatrix[i][j] * result[j];
            }
            result[i] = workMatrix[i][matrix[0].length-1] - sum;
        }
        return result;
    }

    //Обратная матрицы
    public static double[][] inverseMatrix(double[][] matrix) {
        if (matrix.length != matrix[0].length) {
            return null;
        }
        double[][] workMatrix = new double[matrix.length][2 * matrix.length];
        for (int i = 0; i < workMatrix.length; i++) {
            for (int j = 0; j < workMatrix[0].length; j++) {
                if ((i < matrix.length) && (j < matrix.length)) {
                    workMatrix[i][j] = matrix[i][j];
                }
                if (j - matrix.length+1 == i) {
                    workMatrix[i][j] = 1;
                }
            }
        }
        double[][] gaussMatrix = gauss(workMatrix);
        double sum;
        double[][] result = new double[matrix.length][matrix.length];
        for (int k = 0; k < result.length; k++) {
            for (int i = matrix.length - 1; i >= 0; i--) {
                sum = 0;
                for (int j = i + 1; j < matrix.length; j++) {
                    sum += gaussMatrix[i][j] * result[j][k];
                }
                result[i][k] = gaussMatrix[i][gaussMatrix[0].length + k - 3] - sum;
            }
        }
        return result;
    }

    //Умножение матриц
    public static double[][] matrixMultiply(double[][] A, double[][] B) {
        double[][] res = new double[A.length][B[0].length];
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res[0].length; j++) {
                for (int k = 0; k < B.length; k++) {
                    res[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        return res;
    }
    //Вывод вектора
    public static void printVector(double[] vector) {
        for (int i = 0; i < vector.length; i++) {
            System.out.println(vector[i]);
        }
    }

    //Вывод матрицы с именем
    public static void printMatrix(String name, double[][] matrix) {
        System.out.println("Матрица " + name + ":");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println("");
        }
    }

    //Вывод матрицы
    public static void printMatrix(double[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println("");
        }
    }
}
