package db;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.TreeMap;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.StringJoiner;
import java.io.File;
import db.Checker;
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



    void createNewTable (String name, String[] cols) {
        File file = new File(directory);
        File[] tempList = file.listFiles();
        boolean du = false;
        for (int i = 0; i < tempList.length; i++) {
            if ((tempList[i].isFile()) && tempList[i].getName() == name) {
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
                if (Checker.checkColumntype(s[1])) {
                    Column co = new Column(s[0], s[1]);
                    table.addColumn(co);
                    System.out.println("done");
                } else {
                    System.err.println("wrong type" + s[1]);
                }
            }
        }
    }

    void createSelectedTable(String name, String exprs, String tables, String conds) {
        System.out.printf("You are trying to create a table named %s by selecting these expressions:" +
                " '%s' from the join of these tables: '%s', filtered by these conditions: '%s'\n", name, exprs, tables, conds);
        File file = new File(directory);
        File[] tempList = file.listFiles();
        boolean du = false;
        for (int i = 0; i < tempList.length; i++) {
            if ((tempList[i].isFile()) && tempList[i].getName() == name) {
                System.err.println("Duplicated name: " + name);
                du = true;
            }
        }
        if (du == false) {
            //to fill
        }
    }

    void load(String name) throws IOException{
        File file = new File(directory);
        File[] fileList = file.listFiles();
        boolean find = false;               //to complete warning
        for (int i = 0; i < fileList.length; i++) {
            if (fileList[i].isFile() && fileList[i].getName() == name) {
                find = true;
                Table table = new Table(name);
                dataBase.put(name, table);
                FileReader fileFind = new FileReader(fileList[i]);
                BufferedReader br = new BufferedReader(fileFind);
                String line1 = br.readLine();
                if (line1 == null) {
                    System.err.println("missing header" + name);
                } else {
                    String[] header = line1.split(",");
                    for (int j = 0; j < header.length; j++) {
                        String[] columnName = header[i].split("\\s+");
                        if (columnName.length != 2) {
                            System.err.println("wrong header" + name);
                        } else if (! Checker.checkColumntype(columnName[1])) {
                            System.err.println("wrong header");
                        } else {
                            Column co = new Column(columnName[0], columnName[1]);
                            table.addColumn(co);
                        }
                    }
                }
                String line;
                while ((line = br.readLine()) != null) {
                    String[] seg  = line.split(",");
                    if (seg.length != table.columns.size()) {
                        System.err.println("data entries mismatch columns' number");
                    } else {
                        for (int i = 0; i < seg.length; i++) {

                        }
                    }
                }

            }
        }
    }
}
