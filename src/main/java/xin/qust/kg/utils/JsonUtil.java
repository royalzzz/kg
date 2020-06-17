package xin.qust.kg.utils;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class JsonUtil {

    public static JSONObject readJsonFile(String fileName) throws IOException {
        FileReader file = new FileReader(fileName);
        BufferedReader bufferedReader = new BufferedReader(file);
        String text = bufferedReader.readLine();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(text);
        while (text != null) {
            text = bufferedReader.readLine();
            stringBuilder.append(text);
        }
        bufferedReader.close();;
        file.close();
        return new JSONObject(stringBuilder.toString());
    }
}
