package db;

/**
 * Created by 17663 on 2017/7/3.
 */
public class FloatData extends Value{
    public FloatData(String s) {
        this.type = "Float";
        this.value = Float.parseFloat(s);
    }
}
