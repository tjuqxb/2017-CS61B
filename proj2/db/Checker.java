package db;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * Created by 17663 on 2017/7/4.
 */
public class Checker {
    static final private Pattern INT = Pattern.compile("\\d+");
    static final private Pattern FLOAT = Pattern.compile("((0?\\.[0-9]*)|([1-9][0-9]*\\.[0-9]*))");
    static final private Pattern STRING = Pattern.compile("[[\\S]&&[^,']]+");

    static boolean checkColumntype(String s) {
        boolean bl = s == "int" || s == "float" || s == "string";
        return bl;
    }

    static boolean checkInt(String s) {
        return INT.matcher(s).matches();
    }

    static boolean checkFloat(String s) {
        return FLOAT.matcher(s).matches();
    }


}
