package chenqian.site.commontest.controller.encryption;

import chenqian.site.commontest.aspect.OperationLog;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 功能简介:.
 *
 * @author cq
 * @version 1.0
 * *
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @OperationLog(name = "helloAop", value = "this is aop")
    @GetMapping("/aop")
    public String aopTest(String companyName, String companyId) {
        return "success";
    }
}
