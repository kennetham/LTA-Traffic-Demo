/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package properties;

import java.io.*;

/**
 *
 * @author kenneth
 */
public class Utils {

    public static String getStringBetween(String src, String start, String end) {
        StringBuilder strBuilder = new StringBuilder();
        int startIdx = src.indexOf(start) + start.length();
        int endIdx = src.indexOf(end);
        while (startIdx < endIdx) {
            strBuilder.append("" + String.valueOf(src.charAt(startIdx)));
            startIdx++;
        }
        return strBuilder.toString();
    }

    public static String[] IUtils(String _dataServiceQuery) {
        String _data = _dataServiceQuery.toString();
        String[] _temp = null;
        _temp = _data.split("},");
        DataProcess(_temp);
        return _temp;
    }

    public static void DataProcess(String[] _str) {
        PrintWriter out = new PrintWriter(System.out);
        try {
            out.println();
            for (int i = 0; i < _str.length; i++) {
                _str[i] = _str[i].toString();
                out.println(_str[i]);
            }
            out.println();
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (out != null) {
                out.checkError();
                out.flush();
                out.close();
            }
        }
    }
}
