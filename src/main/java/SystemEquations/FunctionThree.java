package SystemEquations;

import static java.lang.Math.sqrt;

public class FunctionThree {

    private final double a = 2.7;
    private final  double b = - 0.3;
    private final  double c = 4.0;
    private final static double EPS = 1e-9;


    public void main(){

    }
    //Item 3
    public double function(double x) {
        if (x < 1.4){
            return a * (x * x) + b * x + c;
        }
        else if (Math.abs((x) - 1.4) < 0.00001){
            return (a / x) + sqrt(x * x + 1);
        }else if(x > 1.4 + EPS){
            return (a + b * x) / sqrt(x * x + 1);
        }
        else {
            return 0;
        }
    }

    //Item 4
    public int numberSteps(double start, double end, double step) {
        return (int) Math.round((end - start) / step + 1);
    }

    //Item 5
    public double[] fillX( double start, double end, double step){
        double[]x = new double[numberSteps(start , end ,step )];
        for (int i = 0 ; i< x.length ; i++){
            x[i] = start + i * step;
        }
        return x;
    }

    public double[] fillY(double[] x){
        double[]y = new double[x.length];
        for (int i = 0 ; i< y.length ; i++){
            y[i] = function(x[i]);
        }
        return y;
    }

    //Item 6

    public double arraySum(double[] x){
        double[]y = fillY(x);
        double sum = 0;
        for (int i = 0; i < y.length; i++) {
            sum += y[i];
        }
        return sum;
    }

    public double arrayAverage(double[] x){
        double[]y = fillY(x);
        double average = arraySum(x) / y.length;
        return average;
    }


    public double  FindMaxY(double[] x ) {
        double[]y = fillY(x);

        double maxValueY = y[0];
        int maxIndexY = 0;

        for (int i = 0; i < y.length ; i++){
            if (y[i] > maxValueY){
                maxValueY = y[i];
                maxIndexY = i;
            }
        }

        return maxValueY;
    }
    //item 7

    public double FindMinY(double[] x) {
        double[]y = fillY(x);

        double minValueY = y[0];
        int minIndexY = 0;

        for (int i = 0; i < y.length ; i++){
            if (y[i] < minValueY){
                minValueY = y[i];
                minIndexY = i;
            }
        }

        // return new Pair<Double, Integer>(minValueY, minIndexY);
        return minValueY;
    }


    public String PrintInfoMaxY(double[] x , int index ){
        double[]y = fillY(x);

        System.out.println("Y = " + FindMaxY(x) + " Index = " + index);
        String str = ("Y = " + FindMaxY(x) + " Index = " + index);

        return str;
    }

    public String PrintInfoMinY(double[] x , int index){
        double[]y = fillY(x);

        System.out.println("Y = " + FindMinY(x) + " Index = " + index);
        String str = ("Y = " + FindMinY(x) + " Index = " + index);

        return str;
    }
}