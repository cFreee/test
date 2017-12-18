package equation;

/**
 * Created by alex on 2017-7-14.
 */
public enum Operator {
    PLUS("+"), MINUS("-"), MULTIPLY("*"), DIVIDE("/"), POW("^");
    String opt;

    Operator (String opt){
        this.opt = opt;
    }

    public static Operator getIstance(int index){
        switch (index){
            case 0:return PLUS;
            case 1:return MINUS;
            case 2:return MULTIPLY;
            case 3:return DIVIDE;
            default:return POW;
        }
    }

    public String getOpt(){
        return opt;
    }
}
