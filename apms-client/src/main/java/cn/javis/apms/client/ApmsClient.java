package cn.javis.apms.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public final class ApmsClient {
    private static Map<ApmsConfig, String> configs = new HashMap<ApmsConfig, String>();

    public static void getRandomKey() {
        readConfig();
    }

    private static void readConfig() {
        try {
            InputStream input = ApmsClient.class.getClassLoader().getResourceAsStream("ApmsClientConfig.properties");
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
            String line = null;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                if (line.startsWith("#"))
                    continue; // comment line ignored
                if (line.isEmpty())
                    continue; // empty line ignored
                String[] pair = line.split("=");
                if (pair.length != 2)
                    continue;
                String key = pair[0].trim();
                String value = pair[1].trim();
                configs.put(ApmsConfig.getValue(key), value);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ApmsClient.getRandomKey();
    }
}
