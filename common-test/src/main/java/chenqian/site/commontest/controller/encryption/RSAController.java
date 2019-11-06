package chenqian.site.commontest.controller.encryption;

import chenqian.site.commontest.service.AbstractEncryption;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import java.security.NoSuchAlgorithmException;

/**
 * 功能简介:.
 *
 * @author cq
 * @version 1.0
 * *
 */
@RestController
@RequestMapping("/rsa")
public class RSAController {

    @Resource
    private AbstractEncryption encryption;

    @GetMapping
    public String getPublicKey() throws NoSuchAlgorithmException {
        return encryption.getPublicKey();
    }


    @PostMapping
    public String decode(String password) throws BadPaddingException, IllegalBlockSizeException {
        return encryption.decryptFromBase64Str(password);
    }
}
