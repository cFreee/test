package calculator;

import equation.Number;
import equation.Operator;

/**
 * Created by alex on 2017-7-14.
 */
public class SimpleCalculator extends Calculate {
    private static CalMode calMode;

    @Override
    public int pow(int a, int b) {
        int powNum = 1;
        for(int i =0; i < b; i++){
            powNum *= a;
        }
        return powNum;
    }

    public void setCalModeIstance(Number a, Number b, Operator opt){
        calMode = new CalMode(a, b, opt);
    }

    public double cal(){
        int a = calMode.getA().ordinal();
        int b = calMode.getB().ordinal();
        switch (calMode.getOpt()){
            case PLUS:
                return plus(a, b);
            case MINUS:
                return minus(a, b);
            case MULTIPLY:
                return multiply(a, b);
            case DIVIDE:
                return divide(a, b);
            case POW:
                return pow(a, b);
        }
        return -1;
    }

    private class CalMode{
       private Number a;
       private Number b;
       private Operator opt;

       public CalMode(Number a, Number b, Operator opt){
           this.a = a;
           this.b = b;
           this.opt = opt;
       }

        public Number getA() {
            return a;
        }

        public Number getB() {
            return b;
        }

        public Operator getOpt() {
            return opt;
        }
    }
}
