package chenqian.site.commontest.httpclient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

/**
 * 功能简介:.
 * *
 */
public class JdkHttpTest {
    public static void main(String[] args) throws IOException {
        URL realUrl = new URL("http://www.baidu.com");
        URLConnection urlConnection = realUrl.openConnection();

        /*try (OutputStream outputStream = urlConnection.getOutputStream()) {
            outputStream.flush();
        }*/
        BufferedReader bufferedReader;
        InputStream inputStream = urlConnection.getInputStream();
        bufferedReader = new BufferedReader(new InputStreamReader((inputStream), "utf-8"));
        System.out.println(urlConnection.getDoInput());
        StringBuilder result = new StringBuilder();
        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
            result.append(line);
        }
        System.out.println(result.toString());
        inputStream.close();
    }
}
