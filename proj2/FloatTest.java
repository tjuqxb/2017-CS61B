import java.math.BigDecimal;
import java.util.ArrayList;

/**
 * Created by 17663 on 2017/7/4.
 */
public class FloatTest {
    public static void main(String[] args) {
        String answer;
        float x = (float) -4.99999;
        int n = 3;
        boolean neg = false;
        String m;
        if (x < 0) {
            m = new BigDecimal(-x).toString();
            neg = true;
        } else {
            m = new BigDecimal(x).toString();
        }
        System.out.println(m);
        char[] mArr = m.toCharArray();
        char[] format = new char[n];
        char[] plus = new char[n + 7];
        for (int i = 0; i < n + 7; i++) {
            plus[i] = '0';
        }
        int index = 0;
        int dotPos = 0;
        int leftPos = 0;
        boolean findDot = false;
        boolean findLeft = false;
        for (int i = 0; i < m.length(); i++) {
            if (mArr[i] == '.') {
                dotPos = i;
                //System.out.println(dotPos);
                findDot = true;
                if (findLeft) {
                    break;
                }
            }
            if (mArr[i] != '0' && mArr[i] != '.') {
                if (findLeft == false) {
                    leftPos = i;
                    findLeft = true;
                    //System.out.println(leftPos);
                }
                for (int j = i; j < mArr.length; j++) {
                    if(index > n + 6) break;
                    if(mArr[j] != '.') {
                        plus[index] = mArr[j];
                        index += 1;
                    }
                }
                for (int j = 0; j < n; j++) {
                    format[j] = plus[j];
                }
                char[] single = new char[8];
                for (int j = 0; j < 7; j++) {
                    single[j] = plus[n + j];
                }
                if (Double.parseDouble(String.copyValueOf(single)) + 5 > 5000000) {
                    int num = Integer.parseInt(String.copyValueOf(format)) + 1;
                    format = String.valueOf(num).toCharArray();
                }
                if (findDot) {
                    break;
                }
            }
        }
        //System.out.println(format);
        if(plus[0] == '0') {
            answer = "0.0";
        } else {
            int e = 0;
            if (dotPos > leftPos) {
                e = dotPos - leftPos - 1;
            } else {
                e = dotPos - leftPos;
            }
            System.out.println(e);
            char[] expFront = new char[n + 1];
            expFront[0] = format[0];
            expFront[1] = '.';
            for (int i = 2; i < n + 1; i++) {
                expFront[i] = format[i - 1];
            }
            ArrayList<String> ful = new ArrayList<String>();
            if (neg) {
                ful.add("-");
            }
            if (e == 0) {
                ful.add(String.copyValueOf(expFront));
            } else {
                ful.add(String.copyValueOf(expFront));
                ful.add("E");
                ful.add(String.valueOf(e));
            }
            answer = String.join("", ful);
        }
        System.out.println(answer);
    }
}

