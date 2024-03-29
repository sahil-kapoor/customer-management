package cn.javis.apms.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public final class ApmsClient {
    private static Map<ApmsConfig, String> configs = new HashMap<ApmsConfig, String>();

    public static void getRandomKey() {
        readConfig();

        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet request = new HttpGet("http://" + configs.get(ApmsConfig.SERVER_URL)
                + "/apms-server/token?username=testmd5");

        try {
            HttpResponse response = client.execute(request);
            HttpEntity entity = response.getEntity();
            int statusCode = response.getStatusLine().getStatusCode();
            switch (statusCode) {
            case HttpStatus.SC_OK: {
                BufferedReader reader = new BufferedReader(new InputStreamReader(entity.getContent()));
                List<Byte> byteList = new ArrayList<Byte>();
                StringBuilder sb = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    sb.append(line);
                }
                // TODO: parser as JSON
            }
            case HttpStatus.SC_NOT_FOUND: {
                break;
            }
            default: {

            }
            }

        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (client != null) {
                try {
                    client.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

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
