package db;

/**
 * Created by 17663 on 2017/7/3.
 */
public class StringData extends Value{
    public StringData(String s) {
        this.type = "String";
        this.value = s;
    }
}
