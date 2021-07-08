/**
 * Created on [2021/7/6 11:37] by cq
 * <p>
 * 项目名称: gaia
 * <p>
 * 本程序版权属于福建慧政通信息科技有限公司所有。
 * 任何组织和个人未经福建慧政通信息科技有限公司许可与授权,不得擅自传播、复制、更改该程序的内容。
 * 本程序受版权法和国际条约的保护。如未经授权而擅自复制或传播本程序(或其中任何部分),
 * 将受到严厉的刑事及民事制裁，并将在法律许可的范围内受到最大可能的起诉!
 * <p>
 * ©2019 福建慧政通信息科技有限公司
 */
package chenqian.site.commontest.httpclient;

import javax.net.ssl.X509TrustManager;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

public class MyX509TrustManager implements X509TrustManager {
    private final X509TrustManager tm;

    public MyX509TrustManager(X509TrustManager tm) {
        this.tm = tm;
    }

    @Override
    public void checkClientTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {
        tm.checkClientTrusted(x509Certificates, s); // 检查客户端
    }

    @Override
    public void checkServerTrusted(X509Certificate[] x509Certificates, String s) throws CertificateException {
        for (X509Certificate x509Certificate : x509Certificates) {
            x509Certificate.checkValidity();
        }
        tm.checkClientTrusted(x509Certificates, s);

    }

    @Override
    public X509Certificate[] getAcceptedIssuers() {
        return new X509Certificate[0];
    }
}
