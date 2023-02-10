import java.util.Objects;

public class Translation implements Runnable {
    protected int num;
    public String rT;
    public String eT;

    public Translation(int num) {
        this.num = num;
    }

    protected boolean test(int num) {
        return !(num < 0 | num > 99);
    }

    protected NumTypes analyze(int num) {
        if (num < 10) {
            return NumTypes.SIMPLE;
        }
        if (num < 20) {
            return NumTypes.PRE_COMPOSITE;
        }
        var fc = getFirstClass(num);

        return fc == 0 ? NumTypes.COMPOSITE_DEC : NumTypes.COMPOSITE;
    }

    protected int getFirstClass(int num) {
        return num - (num / 10) * 10;
    }

    protected int getSecondClass(int num) {
        return num / 10;
    }

    @Override
    public void run() {

    }
}
