package chenqian.site.commontest.feign;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.io.IOUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * 功能简介:.
 * *
 */

@RequestMapping("/feign-test")
@RestController
public class FeignTest {
    @Resource
    private MatieralFeign matieralFeign;

    @GetMapping("/test")
    public String test() throws Exception {
        FileItemFactory factory = new DiskFileItemFactory(16, null);
        FileItem item = factory.createItem("fil2e", "image/jpeg", true, "test.jpg");
        File file = new File("C:/Users/cq/Pictures/64b28437b0284528d1c82711f8792216_1.jpg");
        InputStream input = new FileInputStream(file);
        OutputStream os = item.getOutputStream();
        IOUtils.copy(input, os);
        CommonsMultipartFile commonsMultipartFile = new CommonsMultipartFile(item);
        String insert = matieralFeign.insert("", 26, "eac4ed21187f4509a79ba88ddde1fb25",
                "eac4ed21187f4509a79ba88ddde1fb25", commonsMultipartFile, "B79E701B21C04B259BCD92C4F9868F50");
        return insert;
    }
}
