package ProjectionMethodsBoundaryValueProblems;

import Tools.Tools;

public class ProjectionMethods {
    public static void main(String[] args) {
        Polinom polinom = new Polinom(1);
        double[][] matrix = {{1,5,1},{0,1,5},{3,0,1}};
        double[][] invers = Tools.inverseMatrix(matrix);
        Tools.printMatrix(Tools.matrixMultiply(matrix, invers));
    }
}
