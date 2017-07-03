package db;

/**
 * Created by 17663 on 2017/7/3.
 */
public abstract class Value<k> {
    public k value;
    private boolean isNAN = false;
    private boolean isNOVALUE = false;
    public  String type;
    public void toNAN() {
        this.isNAN = true;
    }
    public void toNOVALUE() {
        this.isNOVALUE = true;
    }
    public k getValue() {
        return  this.value;
    }
}
