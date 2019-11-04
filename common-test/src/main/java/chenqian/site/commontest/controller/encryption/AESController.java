package chenqian.site.commontest.controller.encryption;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

/**
 * 功能简介:.
 *
 * @author cq
 * @version 1.0
 * *
 */
@RestController
@RequestMapping("/aes")
public class AESController {

    private String key;

    @GetMapping
    public String getKey() throws NoSuchAlgorithmException {
        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(256);
        SecretKey secretKey = keyGenerator.generateKey();
        key = new String(Base64.getEncoder().encode(secretKey.getEncoded()));
        return key;
    }


    @PostMapping
    public String decryp(String password,String iv) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException, InvalidAlgorithmParameterException {
        SecretKeySpec secretKeySpec = new SecretKeySpec(Base64.getDecoder().decode(key.getBytes()), "AES");
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, new IvParameterSpec(Base64.getDecoder().decode(iv.getBytes())));
        byte[] data = cipher.doFinal(Base64.getDecoder().decode(password.getBytes()));
        return new String(data);
    }
}
