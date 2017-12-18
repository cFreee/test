package calculator;

/**
 * Created by alex on 2017-7-14.
 */
public class Calculate implements Cal {
    public int plus(int a, int b) {
        return a + b;
    }

    public int minus(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        return a * b;
    }

    public double divide(int a, int b) {
        return a * 1.0 / b;
    }
    //Pow
    public int pow(int a, int b){return 0;};
}
