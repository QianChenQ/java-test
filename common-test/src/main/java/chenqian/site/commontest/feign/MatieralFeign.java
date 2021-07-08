package chenqian.site.commontest.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

/**
 * 功能简介:.
 * *
 */
@FeignClient(name = "MatieralFeign", url = "http://localhost:18060")
public interface MatieralFeign {

    @PostMapping(value = "/scanImage/insert", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    String insert(@RequestParam("remark") String remark,
                  @RequestParam("scanTypeId") Integer scanTypeId,
                  @RequestParam("primaryGuid") String primaryGuid,
                  @RequestParam("primaryId") String primaryId,
                  @RequestPart("file") MultipartFile file, @RequestHeader("USER_ID") String userId);
}
