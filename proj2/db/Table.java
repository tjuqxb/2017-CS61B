package db;

import java.util.ArrayList;
import java.util.TreeMap;

/**
 * Created by 17663 on 2017/7/3.
 */
public class Table {
    String name;
    ArrayList<Column> columns = null;
    public Table(String name) {
        this.name = name;
    }
    public void addColumn(Column s) {
        columns.add(s);
    }
}
