package xin.qust.kg.utils;

import java.io.*;
import java.util.*;

public class CsvUtil {

    public static List<String> readCsvFile(String fileName, int beginRow) {
        List<String> csvText = new ArrayList<>();
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new FileReader(fileName));
            String line = "";
            int row = 0;
            while (bufferedReader.ready()) {
                row ++;
                line = bufferedReader.readLine();
                if (row > beginRow) {
//                StringTokenizer stringTokenizer = new StringTokenizer(line, ",");
//                if (stringTokenizer.hasMoreElements()) {
//                    csvText.add(stringTokenizer.nextElement().toString());
//                }
                    csvText.add(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return csvText;
    }
}
