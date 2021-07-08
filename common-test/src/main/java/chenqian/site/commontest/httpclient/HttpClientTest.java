package chenqian.site.commontest.httpclient;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;

/**
 * 功能简介:.
 * *
 */
public class HttpClientTest {
    public static void main(String[] args) throws IOException, KeyStoreException, CertificateException, NoSuchAlgorithmException {
        File file = new File("D:\\Development\\Workspace\\git\\java-test\\common-test\\src\\main\\resources\\dsports-client.keystore");
        InputStream in = new FileInputStream(file);
        KeyStore ks = KeyStore.getInstance(KeyStore.getDefaultType());
        ks.load(in, "dsports_client_2021".toCharArray());
        in.close();
        TrustManagerFactory tmf = TrustManagerFactory
                .getInstance(TrustManagerFactory.getDefaultAlgorithm());
        tmf.init(ks);
        X509TrustManager defaultTrustManager = (X509TrustManager) tmf
                .getTrustManagers()[0];
        MyX509TrustManager myX509TrustManager = new MyX509TrustManager(defaultTrustManager);
        SSLContext sslcontext = null;
        try {
            sslcontext = SSLContext.getInstance("TLS");
            sslcontext.init(null, new TrustManager[]{myX509TrustManager}, new java.security.SecureRandom());
        } catch (Exception e) {
        }
        HttpClient httpClient = HttpClientBuilder.create().setSSLContext(sslcontext).setSSLHostnameVerifier((s, sslSession) -> true).build();
        HttpGet httpGet = new HttpGet("https://www.baidu.com");// 请求地址
        HttpResponse httpResponse = httpClient.execute(httpGet);
        HttpEntity entity = httpResponse.getEntity();

        String s = EntityUtils.toString(entity);
        System.out.println(s);



    }
}
