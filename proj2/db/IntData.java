package db;

/**
 * Created by 17663 on 2017/7/3.
 */
public class IntData extends Value{
    public IntData(String s) {
        this.type = "Integer";
        this.value = Integer.parseInt(s);
    }
}

