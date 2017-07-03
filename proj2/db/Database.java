package db;
import java.util.TreeMap;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.StringJoiner;
import java.io.File;
public class Database {
    TreeMap<String, Table> dataBase;
    String directory = "D:\\CS\\CS61B2017\\proj2\\Database";


    public Database() {
        // YOUR CODE HERE
        this.dataBase = null;
    }

    public String transact(String query)
    {
        Transact transact = new Transact(this);
        return transact.eval(query);
    }

    private void createNewTable (String name, String[] cols) {
        File file = new File(directory);
        File[] tempList = file.listFiles();
        boolean du = false;
        for (int i = 0; i < tempList.length; i++) {
            if ((tempList[i].isFile()) && tempList[i].toString() == name) {
                System.err.println("Duplicated name: " + name);
                du = true;
            }
        }
        if (du == false) {
            StringJoiner joiner = new StringJoiner(", ");
            for (int i = 0; i < cols.length - 1; i++) {
                joiner.add(cols[i]);
            }
            String colSentence = joiner.toString() + " and " + cols[cols.length - 1];
            System.out.printf("You are trying to create a table named %s with the columns %s\n", name, colSentence);
            Table table = new Table(name);
            dataBase.put(name, table);
            for (int i = 0; i < cols.length; i++) {
                String s[] = cols[i].split("\\s+");
                Column co = new Column(s[0], s[1]);
                table.addColumn(co);
            }
            System.out.println("done");
        }
    }

    private void createSelectedTable(String name, String exprs, String tables, String conds) {
        System.out.printf("You are trying to create a table named %s by selecting these expressions:" +
                " '%s' from the join of these tables: '%s', filtered by these conditions: '%s'\n", name, exprs, tables, conds);
        File file = new File(directory);
        File[] tempList = file.listFiles();
        boolean du = false;
        for (int i = 0; i < tempList.length; i++) {
            if ((tempList[i].isFile()) && tempList[i].toString() == name) {
                System.err.println("Duplicated name: " + name);
                du = true;
            }
        }
        if (du == false) {
    }
}
