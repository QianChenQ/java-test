package chenqian.site.commontest.httpclient;

import org.apache.http.HttpEntity;
import org.apache.http.client.fluent.Content;
import org.apache.http.client.fluent.Form;
import org.apache.http.client.fluent.Request;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.mime.MultipartEntityBuilder;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * 功能简介:.
 * *
 */
public class HttpFluentClientTest {
    public static void main(String[] args) throws IOException {
        File file = new File("C:/Users/cq/Pictures/64b28437b0284528d1c82711f8792216_1.jpg");

        Content content = Request.Get("http://www.baidu.com").execute().returnContent();
        Content username = Request.Post("http://www.baidu.com").bodyForm(Form.form()
                .add("username", "").build()).execute().returnContent();
        Request.Post("http://www.baidu.com").bodyFile(file, ContentType.create(Files.probeContentType(Paths.get("C:/Users/cq/Pictures/64b28437b0284528d1c82711f8792216_1.jpg"))));
        HttpEntity build = MultipartEntityBuilder.create()
                .addBinaryBody("file", file, ContentType.create(Files.probeContentType(Paths.get("C:/Users/cq/Pictures/64b28437b0284528d1c82711f8792216_1.jpg"))), "test.jpg")
                .addTextBody("primaryGuid", "eac4ed21187f4509a79ba88ddde1fb25")
                .addTextBody("primaryId", "eac4ed21187f4509a79ba88ddde1fb25")
                .addTextBody("scanTypeId", "26")
                .build();
        Content userName =
                Request.Post("http://192.168.171.131:17990/material/scanImage/insert?time=1622261616771")
                        .body(build)
                        .addHeader("token","")
                        .execute().returnContent();
        System.out.println(userName);


    }
}
