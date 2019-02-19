package ProjectionMethodsBoundaryValueProblems;

public class Polinom {
    private int k;
    public Polinom(int k) {
        this.k = k;
    }
    public double nextPolinom(int n, double x){
        if (n == 0){
            return 1;
        }
        if (n == 1) {
            return (k +1)*x;
        }
        return ((n+k)*(2*(n-1)+2*k+3)*x*nextPolinom(n-1, x)-(n+k)*(n+k-1)*nextPolinom(n-2, x))/(n*(n+2*k));
    }
}
