package db;

import java.util.ArrayList;

/**
 * Created by 17663 on 2017/7/3.
 */
public class Column {
    String name;
    String type;
    ArrayList<Value> values = null;
    public Column(String name, String type) {
        this.name = name;
        this.type = type;
    }
}
