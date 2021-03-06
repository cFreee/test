package equation;

/**
 * Created by alex on 2017-7-14.
 */
public enum Number {
    ZERO(0), ONE(1), TWO(2), THREE(3), FOUR(4), FIVE(5),
              SIX(6), SEVEN(7), EIGHT(8), NINE(9);
    private int num;

    Number(int num){
        this.num = num;
    }

    public static Number getInstance(int index){
        switch (index){
            case 0: return ZERO;
            case 1: return ONE;
            case 2: return TWO;
            case 3: return THREE;
            case 4: return FOUR;
            case 5: return FIVE;
            case 6: return SIX;
            case 7: return SEVEN;
            case 8: return EIGHT;
            default: return NINE;
        }
    }
}
